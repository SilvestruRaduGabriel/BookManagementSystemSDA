package com.sda.ro.silvestruradugabriel.bms.controller;

import com.sda.ro.silvestruradugabriel.bms.service.ReviewService;
import com.sda.ro.silvestruradugabriel.bms.service.ReviewServiceImpl;
import com.sda.ro.silvestruradugabriel.bms.service.exceptions.BookNotFoundException;

import java.util.Scanner;

public class ReviewControllerImpl implements ReviewController {

    private static final Scanner SCANNER = new Scanner(System.in);
    private ReviewService reviewService;

    public ReviewControllerImpl() {
        this.reviewService = new ReviewServiceImpl();
    }

    @Override
    public void addReview() {
        System.out.println("Please insert the Book Id:");
        Integer bookId = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Please insert the score:");
        Integer score = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Please insert the comment:");
        String comment = SCANNER.nextLine();
        try {
            reviewService.createReview(score, comment, bookId);
        } catch (BookNotFoundException e) {
            System.out.println("Book not found!");
        }
    }
}
