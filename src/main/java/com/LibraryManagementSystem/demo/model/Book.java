package com.LibraryManagementSystem.demo.model;


import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    private String isbn;
    @Column(name = "title")
    private String title;
    private String category;
    private Integer quantity;

    public Book() {
    }

    public Book(String isbn, String title, String category, Integer quantity) throws IllegalArgumentException {
        if (quantity < 0) {
            throw new IllegalArgumentException("quantity cannot be negative.");
        }
        this.isbn = isbn;
        this.title = title;
        this.category = category;
        this.quantity = quantity;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {

        this.category = category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) throws IllegalArgumentException {
        if (quantity < 0) {
            throw new IllegalArgumentException("quantity cannot be negative.");
        }
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
