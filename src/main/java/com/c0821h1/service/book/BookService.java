package com.c0821h1.service.book;

import com.c0821h1.config.SingletonConnection;
import com.c0821h1.model.Book;
import com.c0821h1.model.CategoryBook;
import sun.dc.pr.PRError;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookService implements IBookService {
    public static final String SELECT_ALL_BOOK = "SELECT * FROM books JOIN categoryBook ON books.Id_category = categoryBook.idCategory;";
    public static final String INSERT_BOOK = "INSERT INTO books (nameBook, descriptionBook, producerBook, Id_category, price) value (?, ?, ?, ?, ?)";
    public static final String SELECT_BOOK_BY_ID = "SELECT * FROM books JOIN categoryBook ON books.Id_category = categoryBook.idCategory WHERE idBook = ?";
    public static final String UPDATE_BOOK = "UPDATE books set nameBook = ?, descriptionBook = ?, producerBook = ?, Id_category = ?, price = ? WHERE idBook = ?";
    public static final String DELETE_BOOK_BY_ID = "DELETE FROM books WHERE idBook = ?";
    public static final String SORT_BOOK_BY_NAME = "SELECT * FROM books JOIN categoryBook ON books.Id_category = categoryBook.idCategory ORDER BY nameBook;";
    public static final String SELECT_BOOK_BY_NAME = "SELECT * FROM books JOIN categoryBook ON books.Id_category = categoryBook.idCategory WHERE nameBook LIKE ?;";
    public static final String SELECT_BOOK_BY_PRODUCER = "SELECT * FROM books JOIN categoryBook ON books.Id_category = categoryBook.idCategory WHERE producerBook LIKE ?;";
    public static final String SELECT_BOOK_BY_CATEGORY = "SELECT * FROM books JOIN categoryBook ON books.Id_category = categoryBook.idCategory WHERE nameCategory LIKE ?;";


    private static Connection connection = SingletonConnection.getConnection();


    @Override
    public List<Book> findAll(String query) {
        List<Book> bookList = new ArrayList<>();
        CategoryBook categoryBook;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idBook = resultSet.getInt("idBook");
                String nameBook = resultSet.getString("nameBook");
                String description = resultSet.getString("descriptionBook");
                String producer = resultSet.getString("producerBook");
                double price = resultSet.getDouble("price");
                int id_category = resultSet.getInt("Id_category");
                String nameCategory = resultSet.getString("nameCategory");
                categoryBook = new CategoryBook(id_category, nameCategory);
                bookList.add(new Book(idBook, nameBook, description, producer, price, categoryBook));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bookList;
    }


    @Override
    public void insert(Book book) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK);
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getDescription());
            preparedStatement.setString(3, book.getProducer());
            preparedStatement.setInt(4, book.getCategory().getId());
            preparedStatement.setDouble(5, book.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public Book select(int id) {
        Book book = new Book();
        CategoryBook categoryBook = new CategoryBook();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int idBook = resultSet.getInt("idBook");
                String nameBook = resultSet.getString("nameBook");
                String description = resultSet.getString("descriptionBook");
                String producer = resultSet.getString("producerBook");
                double price = resultSet.getDouble("price");
                int Id_category = resultSet.getInt("Id_category");
                String nameCategory = resultSet.getString("nameCategory");
                categoryBook.setId(Id_category);
                categoryBook.setName(nameCategory);
                book = new Book(idBook, nameBook, description, producer, price, categoryBook);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return book;
    }

    @Override
    public boolean update(Book book) {
        boolean rowUpdate = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOK);
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getDescription());
            preparedStatement.setString(3, book.getProducer());
            preparedStatement.setInt(4, book.getCategory().getId());
            preparedStatement.setDouble(5, book.getPrice());
            preparedStatement.setInt(6, book.getId());
            rowUpdate = preparedStatement.executeUpdate() > 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(int id) {
        boolean rowDelete = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOK_BY_ID);
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDelete;
    }
@Override
    public List<Book> selectALLBook() {
        return findAll(SELECT_ALL_BOOK);
    }
@Override
    public List<Book> sortBookByName() {
        return findAll(SORT_BOOK_BY_NAME);
    }
@Override
    public List<Book> searchBookByProducer(String inputSearch) {
        return searchBook(SELECT_BOOK_BY_PRODUCER, inputSearch);
    }
@Override
    public List<Book> searchBook (String query, String inputSearch) {
        List<Book> bookList = new ArrayList<>();
        CategoryBook categoryBook = new CategoryBook();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            inputSearch = "%" + inputSearch + "%";
            preparedStatement.setString(1, inputSearch);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idBook = resultSet.getInt("idBook");
                String nameBook = resultSet.getString("nameBook");
                String description = resultSet.getString("descriptionBook");
                String producer = resultSet.getString("producerBook");
                double price = resultSet.getDouble("price");
                int Id_category = resultSet.getInt("Id_category");
                String nameCategory = resultSet.getString("nameCategory");
                categoryBook.setId(Id_category);
                categoryBook.setName(nameCategory);
                bookList.add(new Book(idBook, nameBook, description, producer, price, categoryBook));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bookList;
    }
@Override
    public List<Book> searchBookByName(String inputSearch) {
        return searchBook(SELECT_BOOK_BY_NAME, inputSearch);
    }
    public List<Book> searchBookByCategory(String inputSearch) {
        return searchBook(SELECT_BOOK_BY_CATEGORY, inputSearch);
    }

}
