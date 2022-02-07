package com.sda.ro.silvestruradugabriel.bms.repository;

import com.sda.ro.silvestruradugabriel.bms.model.Author;

public interface AuthorRepository {
    void createAuthor(Author author);

    Author findById(Integer id);

}
