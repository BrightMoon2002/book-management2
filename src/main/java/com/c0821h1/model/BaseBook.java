package com.c0821h1.model;

public abstract class BaseBook {
    abstract void setId(int id);
    abstract int getId();
    abstract void setName(String name);
    abstract String getName();
    abstract void setDescription(String description);
    abstract String getDescription();
    abstract void setProducer(String producer);
    abstract String getProducer();
    abstract void setPrice(double price);
    abstract double getPrice();
    abstract CategoryBook getCategory();
    abstract void setCategory(CategoryBook categoryBook);
}
