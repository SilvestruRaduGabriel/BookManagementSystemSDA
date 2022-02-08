package com.sda.ro.silvestruradugabriel.bms.repository;

import com.sda.ro.silvestruradugabriel.bms.model.Author;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.List;

public interface AuthorRepository extends BaseRepository<Author , Integer>{
    void createAuthor(Author author);

    List<Author> findAll();

}
