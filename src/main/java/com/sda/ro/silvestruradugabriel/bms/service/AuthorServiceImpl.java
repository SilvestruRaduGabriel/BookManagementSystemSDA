package com.sda.ro.silvestruradugabriel.bms.service;

import com.sda.ro.silvestruradugabriel.bms.model.Author;
import com.sda.ro.silvestruradugabriel.bms.repository.AuthorRepository;
import com.sda.ro.silvestruradugabriel.bms.repository.AuthorRepositoryImpl;

public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository; // am facut field ul asta sa putem folosi metoda createAuthor.

    public AuthorServiceImpl() { // sa nu aiba acces nimeni
        authorRepository = new AuthorRepositoryImpl();
    }

    @Override
    public void createAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        //Il trimite mai departe la Repository ( uita-te ca sa intelegi )
        authorRepository.createAuthor(author);
    }
}
