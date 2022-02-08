package com.sda.ro.silvestruradugabriel.bms.controller;

import com.sda.ro.silvestruradugabriel.bms.model.Author;
import com.sda.ro.silvestruradugabriel.bms.service.AuthorService;
import com.sda.ro.silvestruradugabriel.bms.service.AuthorServiceImpl;
import com.sda.ro.silvestruradugabriel.bms.service.exceptions.AuthorNotFoundException;

import java.util.List;
import java.util.Scanner;

public class AuthorControllerImpl implements AuthorController {
    private static final Scanner SCANNER = new Scanner(System.in);

    private AuthorService authorService;

    public AuthorControllerImpl() { // Constructorul asta ne ajuta main pentru a nu insirui Repository , Service, Controller ... si la encapsulare
        authorService = new AuthorServiceImpl();
    }

    @Override
    public void createAuthor() {
        System.out.println("Create Author:");
        System.out.println("Please insert First Name:");
        String firstName = SCANNER.nextLine();
        System.out.println("Please insert Last Name:");
        String lastName = SCANNER.nextLine();

        //autorul creeat il trimtiem la serivce ( uita-te in AuthorService sa intelegi)
        authorService.createAuthor(firstName, lastName);
    }

    @Override
    public void viewAllAuthors() {
        System.out.println("List of Authors");
        List<Author> authors = authorService.findAll();
        for (Author author : authors) {
            System.out.println("First name: " + author.getFirstName());
            System.out.println("Last name: " + author.getLastName());
            System.out.println("Author id: " + author.getId());

        }
    }

    @Override
    public void updateAuthor() {

        System.out.println("Update Author:");
        System.out.println("Please insert the id for author to be updated");
        Integer id =Integer.parseInt(SCANNER.nextLine());
        System.out.println("Please insert first name:");
        String firstName = SCANNER.nextLine();
        System.out.println("Please insert last name:");
        String lastName = SCANNER.nextLine();
        try {
            authorService.update(id, firstName, lastName);
        } catch (AuthorNotFoundException e) {
            System.out.println("Author not found!");
        }
    }
}
