package com.mongodbdemo.unab.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
@Data
public class Book
{
    @Id
    private String id;
    private String title;
    private String author;
    private String isbn;

    public Book()
    {

    }

    public Book(String title, String author, String isbn)
    {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
}