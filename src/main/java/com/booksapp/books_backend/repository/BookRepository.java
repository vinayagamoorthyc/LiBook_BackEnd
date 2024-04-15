package com.booksapp.books_backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.booksapp.books_backend.model.MustBook;

public interface BookRepository extends MongoRepository<MustBook,String>{

    
}
