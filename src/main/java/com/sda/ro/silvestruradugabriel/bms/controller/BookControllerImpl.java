package com.sda.ro.silvestruradugabriel.bms.controller;

import com.sda.ro.silvestruradugabriel.bms.model.Book;
import com.sda.ro.silvestruradugabriel.bms.service.BookService;
import com.sda.ro.silvestruradugabriel.bms.service.BookServiceImpl;

import java.util.Scanner;

public class BookControllerImpl implements BookController {
    private static final Scanner SCANNER = new Scanner(System.in);

    private BookService bookService;

    public BookControllerImpl() { // nu prea am inteles asta
        bookService = new BookServiceImpl();
    }

    @Override
    public void createBook() {
        System.out.println("Create book: ");
        System.out.println("Please insert ISBN: ");
        String isbn = SCANNER.nextLine();
        System.out.println("Please insert Title: ");
        String title = SCANNER.nextLine();
        System.out.println("Please insert Description: ");
        String description = SCANNER.nextLine();

        bookService.createBook(isbn , title , description);
    }
}
