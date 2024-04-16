package com.booksapp.books_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "topStories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopBooks {
    @Id
    private String bookId;
    private String name;
    private String url;
    private String author;
    private String year;
    private String desc;
}
