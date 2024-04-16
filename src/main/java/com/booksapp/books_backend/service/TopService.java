package com.booksapp.books_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booksapp.books_backend.model.TopBooks;
import com.booksapp.books_backend.repository.TopRepository;

@Service
public class TopService {
    @Autowired

    private TopRepository repository;

    public void addOrUpdate(TopBooks book) {
        repository.save(book);
    }

    public Iterable<TopBooks> listAll() {
        return this.repository.findAll();
    }

    public void deleteBook(String bookId) {
        repository.deleteById(bookId);
    }

    public TopBooks getBookById(String bookId) {
        return repository.findById(bookId).get();
    }
    
}
