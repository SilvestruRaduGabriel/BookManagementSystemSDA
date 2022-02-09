package com.sda.ro.silvestruradugabriel.bms.service;

import com.sda.ro.silvestruradugabriel.bms.model.Author;
import com.sda.ro.silvestruradugabriel.bms.model.Review;
import com.sda.ro.silvestruradugabriel.bms.service.exceptions.AuthorNotFoundException;
import com.sda.ro.silvestruradugabriel.bms.service.exceptions.BookNotFoundException;

import java.util.List;

public interface BookService {

    void createBook(String isbn, String title, String description);

    void createBook(String isbn, String title, String description, Integer authorId) throws AuthorNotFoundException;

    void importBooksFromFile();

    List<Review> getReviewsForBook(Integer bookId) throws BookNotFoundException;

}
