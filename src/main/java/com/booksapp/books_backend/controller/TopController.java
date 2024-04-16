package com.booksapp.books_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booksapp.books_backend.model.TopBooks;
import com.booksapp.books_backend.service.TopService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/topbooks")
public class TopController {

    @Autowired
    private TopService service;

    @PostMapping(value = "/create")
    public String createBook(@RequestBody TopBooks book){
        service.addOrUpdate(book);
        return book.getBookId();
    }

    @GetMapping(value = "/getAll")
    public Iterable<TopBooks> getBooks(){
        return service.listAll();
    }

    @PutMapping(value = "/edit/{id}")
    private TopBooks update(@RequestBody TopBooks bookup,@PathVariable (name = "id")String bookId){
        bookup.setBookId(bookId);
        service.addOrUpdate(bookup);
        return bookup;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBooks(@PathVariable("id") String bookId){
        service.deleteBook(bookId);
    }

    @RequestMapping("/search/{id}")
    private TopBooks getBook(@PathVariable("id") String bookId){
        return service.getBookById(bookId);
    }
    
}
