package com.booksapp.books_backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.booksapp.books_backend.model.LoveBooks;

public interface LoveRepository extends MongoRepository<LoveBooks,String>{
    
}
