package com.termos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Date;
@Data
public class Book extends AbstractModel {
    @JsonProperty("book_id")
    private String bookId;
    private String title;
    private String author;
    private float price;
    private String description;
    @JsonProperty("release_date")
    private Date releaseDate;

    public Book(String bookId, String title, String author, float price, String description, Date releaseDate) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    @Override
    public String getId() {
        return bookId;
    }



}