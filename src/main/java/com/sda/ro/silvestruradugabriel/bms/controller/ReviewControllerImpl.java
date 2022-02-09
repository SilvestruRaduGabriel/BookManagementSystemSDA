package com.sda.ro.silvestruradugabriel.bms.controller;

import com.sda.ro.silvestruradugabriel.bms.model.Review;
import com.sda.ro.silvestruradugabriel.bms.service.BookService;
import com.sda.ro.silvestruradugabriel.bms.service.BookServiceImpl;
import com.sda.ro.silvestruradugabriel.bms.service.ReviewService;
import com.sda.ro.silvestruradugabriel.bms.service.ReviewServiceImpl;
import com.sda.ro.silvestruradugabriel.bms.service.exceptions.BookNotFoundException;

import java.util.List;
import java.util.Scanner;

public class ReviewControllerImpl implements ReviewController {

    private static final Scanner SCANNER = new Scanner(System.in);
    private ReviewService reviewService;
    private BookService bookService;



    public ReviewControllerImpl() {
        this.bookService = new BookServiceImpl();
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

    @Override
    public void getReviewForBook() {
        System.out.println("Please insert Book id");
        Integer bookId = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Reviews:");
        try {
            bookService.getReviewsForBook(bookId)
                    .stream()
                    .limit(10)
                    .forEach(review -> {
                        System.out.println("Score: " + review.getScore());
                        System.out.println("Comment:" + review.getComment());
                    });
        } catch (BookNotFoundException e) {
            System.out.println("Book not found!");
        }
    }
}
