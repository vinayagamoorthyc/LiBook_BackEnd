package com.booksapp.books_backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.booksapp.books_backend.model.Book;

public interface BookRepository extends MongoRepository<Book,String>{

    
}
