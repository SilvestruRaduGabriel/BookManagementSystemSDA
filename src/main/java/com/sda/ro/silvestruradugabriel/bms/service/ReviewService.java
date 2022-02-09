package com.sda.ro.silvestruradugabriel.bms.service;


import com.sda.ro.silvestruradugabriel.bms.service.exceptions.BookNotFoundException;

public interface ReviewService {

    void createReview(Integer score, String comment, Integer bookId) throws BookNotFoundException;
}
