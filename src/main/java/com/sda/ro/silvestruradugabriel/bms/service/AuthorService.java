package com.sda.ro.silvestruradugabriel.bms.service;

import com.sda.ro.silvestruradugabriel.bms.model.Author;
import com.sda.ro.silvestruradugabriel.bms.service.exceptions.AuthorNotFoundException;

import java.util.List;

public interface AuthorService {
    void createAuthor(String firstName, String lastName);

    List<Author> findAll();

    void importAuthorsFromFile();

    void update(Integer id, String firstName, String lastName) throws AuthorNotFoundException;

    void delete(Integer id) throws AuthorNotFoundException;

}
