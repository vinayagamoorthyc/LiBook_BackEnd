package com.booksapp.books_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booksapp.books_backend.model.LoveBooks;
import com.booksapp.books_backend.repository.LoveRepository;

@Service
public class LoveService {

    @Autowired
    private LoveRepository repository;

    public void addOrUpdate(LoveBooks book) {
        repository.save(book);
    }

    public Iterable<LoveBooks> listAll() {
        return this.repository.findAll();
    }

    public void deleteBook(String bookId) {
        repository.deleteById(bookId);
    }

    public LoveBooks getBookById(String bookId) {
        return repository.findById(bookId).get();
    }
    
}
