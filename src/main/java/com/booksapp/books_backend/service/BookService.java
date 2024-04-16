package com.booksapp.books_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booksapp.books_backend.model.MustBook;
import com.booksapp.books_backend.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public void addOrUpdate(MustBook book) {
        repository.save(book);
    }

    public Iterable<MustBook> listAll() {
        return this.repository.findAll();
    }

    public void deleteBook(String bookId) {
        repository.deleteById(bookId);
    }

    public MustBook getBookById(String bookId) {
        return repository.findById(bookId).get();
    }

}
