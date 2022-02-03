package com.sda.ro.silvestruradugabriel.bms.controller;

import com.sda.ro.silvestruradugabriel.bms.service.AuthorService;
import com.sda.ro.silvestruradugabriel.bms.service.AuthorServiceImpl;

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
}
