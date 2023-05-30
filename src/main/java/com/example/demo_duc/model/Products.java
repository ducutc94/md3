package com.example.demo_duc.model;

import java.time.LocalDate;

public class Products {
    private int id;
    private String name;
    private double price;
    private LocalDate date;
    private Category category;

    public Products(int id, String name, double price, LocalDate date, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
        this.category = category;
    }

    public Products() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
