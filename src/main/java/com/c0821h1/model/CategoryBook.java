package com.c0821h1.model;

public class CategoryBook {
    private int id;
    private String name;

    public CategoryBook() {
    }

    public CategoryBook(String name) {
        this.name = name;
    }

    public CategoryBook(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
