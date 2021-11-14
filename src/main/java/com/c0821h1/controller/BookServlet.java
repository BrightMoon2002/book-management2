package com.c0821h1.controller;

import com.c0821h1.model.Book;
import com.c0821h1.model.CategoryBook;
import com.c0821h1.service.book.BookService;
import com.c0821h1.service.book.IBookService;
import com.c0821h1.service.categoryBook.CategoryBookService;
import com.c0821h1.service.categoryBook.ICategoryBook;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BookServlet", value = "/books")
public class BookServlet extends HttpServlet {
    private ICategoryBook categoryService = new CategoryBookService();
    private IBookService bookService = new BookService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "searchCategory":
                showListByCategory(request, response);
                break;
            case "search":
                showList(request, response);
                break;
            default:
                showList(request, response);
                break;
        }
    }

    private void showListByCategory(HttpServletRequest request, HttpServletResponse response) {
        String idCategory = request.getParameter("searchC");
        List<Book> productList;
        productList = bookService.searchBookByCategory(idCategory);
        request.setAttribute("list", productList);
        RequestDispatcher dispatcher;
        if (productList == null) {
            dispatcher = request.getRequestDispatcher("product/error-404.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("product/list.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Book bookEdit = bookService.select(id);
        request.setAttribute("bookEdit", bookEdit);
        request.setAttribute("category", categoryService.selectALLBook());
        RequestDispatcher dispatcher;
        if (bookEdit == null) {
            dispatcher = request.getRequestDispatcher("view/book/error.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("view/book/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Book bookDelete = bookService.select(id);
        request.setAttribute("bookDelete", bookDelete);
        RequestDispatcher dispatcher;
        if (bookDelete == null) {
            dispatcher = request.getRequestDispatcher("view/book/error.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("view/book/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Book> bookList;
        String producer = request.getParameter("searchP");
        String category = request.getParameter("searchC");
        RequestDispatcher dispatcher;
        if (producer == null && category == null) {
            bookList = bookService.selectALLBook();
            dispatcher = request.getRequestDispatcher("view/book/list.jsp");
        } else if (category == null) {
            bookList = bookService.searchBookByProducer(producer);
//            request.setAttribute("list", bookList);
//            RequestDispatcher dispatcher;
            if (bookList == null) {
                dispatcher = request.getRequestDispatcher("view/book/error.jsp");
            } else {
                dispatcher = request.getRequestDispatcher("view/book/list.jsp");
            }
        } else {
            bookList = bookService.searchBookByCategory(category);

            if (bookList == null) {
                dispatcher = request.getRequestDispatcher("view/book/error.jsp");
            } else {
                dispatcher = request.getRequestDispatcher("view/book/list.jsp");
            }
        }
        request.setAttribute("list", bookList);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("categoryList", categoryService.selectALLBook());
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/book/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                creatNewBook(request, response);
                break;
            case "delete":
                deleteBook(request, response);
                break;
            case "edit":
                editBook(request, response);
                break;
            case "search":
            default:
                showList(request, response);
                break;
        }
    }

    private void editBook(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        if (bookService.select(id) == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/book/error.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String producer = request.getParameter("producer");
            double price = Double.parseDouble(request.getParameter("price"));
            int idCategory = Integer.parseInt(request.getParameter("idCategory"));
            CategoryBook categoryBook = categoryService.select(idCategory);
            Book book = new Book(id, name, description, producer, price, categoryBook);
            bookService.update(book);

            try {
                response.sendRedirect("/books");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response) {
        int idBook = Integer.parseInt(request.getParameter("id"));
        Book bookDelete = bookService.select(idBook);

        if (bookDelete == null) {
          RequestDispatcher  dispatcher = request.getRequestDispatcher("view/book/error.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            bookService.delete(bookDelete.getId());
            try {
                response.sendRedirect("/books");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    private void creatNewBook(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String producer = request.getParameter("producer");
        double price = Double.parseDouble(request.getParameter("price"));
        int idCategoryBook = Integer.parseInt(request.getParameter("idCategory"));
        CategoryBook categoryBook = categoryService.select(idCategoryBook);
        Book book = new Book(name, description, producer, price, categoryBook);
        bookService.insert(book);
        try {
            response.sendRedirect("/books");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
