package com.sda.ro.silvestruradugabriel.bms.repository;

import com.sda.ro.silvestruradugabriel.bms.model.Review;
import com.sda.ro.silvestruradugabriel.bms.utils.SessionManager;

public class ReviewRepositoryImpl extends BaseRepositoryImpl<Review, Integer> implements ReviewRepository {

    public ReviewRepositoryImpl() {
        super(Review.class);
    }
}
