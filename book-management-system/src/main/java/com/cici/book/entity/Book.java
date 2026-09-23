package com.cici.book.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Book {
    private Integer id;
    private String title;
    private String author;
    private BigDecimal price;
    private LocalDate publishDate;

    public Book() {}

    public Book(Integer id, String title, String author, BigDecimal price, LocalDate publishDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.publishDate = publishDate;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public LocalDate getPublishDate() { return publishDate; }
    public void setPublishDate(LocalDate publishDate) { this.publishDate = publishDate; }

    @Override
    public String toString() {
        return "Book{id=" + id + ", title='" + title + "', author='" + author + "', price=" + price + ", publishDate=" + publishDate + "}";
    }
}