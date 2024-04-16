package com.booksapp.books_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booksapp.books_backend.model.LoveBooks;
import com.booksapp.books_backend.service.LoveService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/lovebooks")
public class LoveController {
    
    @Autowired
    private LoveService service;

    @PostMapping(value = "/create")
    public String createBook(@RequestBody LoveBooks book){
        service.addOrUpdate(book);
        return book.getBookId();
    }

    @GetMapping(value = "/getAll")
    public Iterable<LoveBooks> getBooks(){
        return service.listAll();
    }

    @PutMapping(value = "/edit/{id}")
    private LoveBooks update(@RequestBody LoveBooks bookup,@PathVariable (name = "id")String bookId){
        bookup.setBookId(bookId);
        service.addOrUpdate(bookup);
        return bookup;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBooks(@PathVariable("id") String bookId){
        service.deleteBook(bookId);
    }

    @RequestMapping("/search/{id}")
    private LoveBooks getBook(@PathVariable("id") String bookId){
        return service.getBookById(bookId);
    }
}
