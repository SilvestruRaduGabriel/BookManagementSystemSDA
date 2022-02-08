package com.sda.ro.silvestruradugabriel.bms.service;

import com.sda.ro.silvestruradugabriel.bms.model.Author;

import java.util.List;

public interface AuthorService {
    void createAuthor(String firstName, String lastName);

    List<Author> findAll();

    void importAuthorsFromFile();
}
