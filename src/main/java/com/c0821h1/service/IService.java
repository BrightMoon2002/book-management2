package com.c0821h1.service;

import com.c0821h1.model.Book;

import java.util.List;

public interface IService<T> {

    List<T> findAll(String query);

    void insert(T t);

    T select(int id);

    boolean update(T t);

    boolean delete(int id);
    List<T> searchBook (String query, String inputSearch);
    List<T> searchBookByName(String inputSearch);
    List<T> selectALLBook();
    List<T> sortBookByName();
    List<T> searchBookByProducer(String inputSearch);
    List<T> searchBookByCategory(String inputSearch);
}
