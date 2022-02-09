package com.sda.ro.silvestruradugabriel.bms.service;

import com.sda.ro.silvestruradugabriel.bms.model.Book;
import com.sda.ro.silvestruradugabriel.bms.model.Review;
import com.sda.ro.silvestruradugabriel.bms.repository.BookRepository;
import com.sda.ro.silvestruradugabriel.bms.repository.BookRepositoryImpl;
import com.sda.ro.silvestruradugabriel.bms.repository.ReviewRepository;
import com.sda.ro.silvestruradugabriel.bms.repository.ReviewRepositoryImpl;
import com.sda.ro.silvestruradugabriel.bms.service.exceptions.AuthorNotFoundException;
import com.sda.ro.silvestruradugabriel.bms.service.exceptions.BookNotFoundException;

public class ReviewServiceImpl implements ReviewService {

    private BookRepository bookRepository;
    private ReviewRepository reviewRepository;

    public ReviewServiceImpl() {
        bookRepository = new BookRepositoryImpl();
        reviewRepository = new ReviewRepositoryImpl();
    }

    @Override
    public void createReview(Integer score, String comment, Integer bookId) throws BookNotFoundException {
        Book book = bookRepository.findById(bookId);
        if (book != null) {
            Review review = new Review();
            review.setScore(score);
            review.setComment(comment);
            review.setBook(book);
            reviewRepository.createEntity(review);
        }else {
            throw new BookNotFoundException("Book not found !" , bookId);
        }
    }
}
