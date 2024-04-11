package com.booksapp.books_backend.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booksapp.books_backend.model.Book;
import com.booksapp.books_backend.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public void addOrUpdate(Book book) {
        repository.save(book);
    }

    public Iterable<Book> listAll() {
        return this.repository.findAll();
    }

    public void deleteBook(String bookId) {
        repository.deleteById(bookId);
    }

    public Book getBookById(String bookId) {
        return repository.findById(bookId).get();
    }

}
