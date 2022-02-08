package com.sda.ro.silvestruradugabriel.bms.service;

import com.sda.ro.silvestruradugabriel.bms.model.Author;
import com.sda.ro.silvestruradugabriel.bms.service.exceptions.AuthorNotFoundException;

public interface BookService {

    void createBook(String isbn, String title, String description);

    void createBook(String isbn, String title, String description, Integer authorId) throws AuthorNotFoundException;


}
