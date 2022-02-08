package com.sda.ro.silvestruradugabriel.bms.service;

import com.sda.ro.silvestruradugabriel.bms.model.Author;
import com.sda.ro.silvestruradugabriel.bms.repository.AuthorRepository;
import com.sda.ro.silvestruradugabriel.bms.repository.AuthorRepositoryImpl;
import com.sda.ro.silvestruradugabriel.bms.service.exceptions.AuthorNotFoundException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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

    @Override
    public List<Author> findAll() {
        List<Author> authorList = authorRepository.findAll();
        return authorList;
    }

    @Override
    public void importAuthorsFromFile() {
//        Path authorsFilePath = Paths.get("/data/authors.txt");
        Path authorFileAbsolutePath = Paths.get("C:\\Users\\gabir\\OneDrive\\Documents\\BookManagementSystemSDA\\data\\authors.txt");
        try {
            Files.lines(authorFileAbsolutePath)
                    .filter(line -> line != null)
                    .filter(line -> !line.isEmpty())
                    .skip(1) //sare un numar de linii
                    .map(line -> {
                        try {
                            String[] lineElements = line.split("\\|");
                            Author author = new Author();
                            author.setFirstName(lineElements[0]); // in java mereu e de la 0
                            author.setLastName(lineElements[1]);
                            return author;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return null;
                        }
                    })
                    .forEach(author -> {
                        if (author != null) {
                            authorRepository.createAuthor(author);
                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, String firstName, String lastName) throws AuthorNotFoundException {
        Author author = authorRepository.findById(id);
        if (author != null) {
            author.setFirstName(firstName);
            author.setLastName(lastName);
            authorRepository.update(author); // cand vreau sa fac ceva in baza de date folosesc authorRepository.
        } else {
            throw new AuthorNotFoundException("Author not found!", author.getId());
        }
    }
}
