package com.c0821h1.service.categoryBook;

import com.c0821h1.config.SingletonConnection;
import com.c0821h1.model.Book;
import com.c0821h1.model.CategoryBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryBookService implements ICategoryBook{
    public static final String SELECT_ALL_CATEGORY = "SELECT * FROM categoryBook;";
    public static final String SELECT_CATEGORY_BY_ID = "SELECT * FROM categoryBook WHERE idCategory = ?";
    public static final String INSERT_CATEGORY = "INSERT INTO categoryBook (nameCategory) VALUE (?);";
    public static final String UPDATE_CATEGORY = "UPDATE categoryBook set name = ?";
    public static final String DELETE_CATEGORY = "DELETE from categoryBook WHERE idCategory = ?";
    private Connection connection = SingletonConnection.getConnection();


    @Override
    public List<CategoryBook> findAll(String query) {
        List<CategoryBook> categoryBookList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idCategory");
                String name = rs.getString("nameCategory");
                categoryBookList.add(new CategoryBook(id, name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categoryBookList;
    }

//    public static void main(String[] args) {
//        CategoryBookService cBS = new CategoryBookService();
//        List<CategoryBook> list = cBS.findAll(SELECT_ALL_CATEGORY);
//        for (CategoryBook c: list
//             ) {
//            System.out.println(c);
//        }
//
//        System.out.println(cBS.select(2));
//    }

    @Override
    public void insert(CategoryBook categoryBook) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATEGORY);
            preparedStatement.setString(1, categoryBook.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public CategoryBook select(int id) {
        CategoryBook categoryBook = new CategoryBook();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                int idCategory = rs.getInt("idCategory");
                String name = rs.getString("nameCategory");
                categoryBook.setName(name);
                categoryBook.setId(idCategory);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return categoryBook;
    }

    @Override
    public boolean update(CategoryBook categoryBook) {
        boolean rowUpdate = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CATEGORY);
            preparedStatement.setString(1, categoryBook.getName());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(int id) {
        boolean rowDelete =false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CATEGORY);
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public List<CategoryBook> searchBook(String query, String inputSearch) {
        return null;
    }

    @Override
    public List<CategoryBook> searchBookByName(String inputSearch) {
        return null;
    }

    @Override
    public List<CategoryBook> selectALLBook() {
        return findAll(SELECT_ALL_CATEGORY);
    }

    @Override
    public List<CategoryBook> sortBookByName() {
        return null;
    }

    @Override
    public List<CategoryBook> searchBookByProducer(String inputSearch) {
        return null;
    }

    @Override
    public List<CategoryBook> searchBookByCategory(String inputSearch) {
        return null;
    }
}
