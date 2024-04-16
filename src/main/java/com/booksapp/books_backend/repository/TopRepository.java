package com.booksapp.books_backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.booksapp.books_backend.model.TopBooks;

public interface TopRepository extends MongoRepository<TopBooks,String> {
    
}
