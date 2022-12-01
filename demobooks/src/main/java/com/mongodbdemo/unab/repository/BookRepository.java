package com.mongodbdemo.unab.repository;

import com.mongodbdemo.unab.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String>
{
    List<Book> findByTitleContaining(String title);
    List<Book> findByAuthor(String name);
}
