package com.c0821h1.model;

public class Book extends BaseBook {
    private int id;
    private String name;
    private String description;
    private String producer;
    private double price;
    private CategoryBook categoryBook;

    public Book() {
    }

    public Book(int id, String name, String description, String producer, double price, CategoryBook categoryBook) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.producer = producer;
        this.price = price;
        this.categoryBook = categoryBook;
    }

    public Book(String name, String description, String producer, double price, CategoryBook categoryBook) {
        this.name = name;
        this.description = description;
        this.producer = producer;
        this.price = price;
        this.categoryBook = categoryBook;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String getProducer() {
        return this.producer;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    double getPrice() {
        return this.price;
    }
}
