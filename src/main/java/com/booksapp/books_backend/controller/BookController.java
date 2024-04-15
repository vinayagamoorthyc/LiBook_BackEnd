package com.booksapp.books_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.booksapp.books_backend.model.MustBook;
import com.booksapp.books_backend.service.BookService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping(value = "/create")
    public String createBook(@RequestBody MustBook book){
        service.addOrUpdate(book);
        return book.getBookId();
    }

    @GetMapping(value = "/getAll")
    public Iterable<MustBook> getBooks(){
        return service.listAll();
    }

    @PutMapping(value = "/edit/{id}")
    private MustBook update(@RequestBody MustBook bookup,@PathVariable (name = "id")String bookId){
        bookup.setBookId(bookId);
        service.addOrUpdate(bookup);
        return bookup;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBooks(@PathVariable("id") String bookId){
        service.deleteBook(bookId);
    }

    @RequestMapping("/search/{id}")
    private MustBook getBook(@PathVariable("id") String bookId){
        return service.getBookById(bookId);
    }

}
