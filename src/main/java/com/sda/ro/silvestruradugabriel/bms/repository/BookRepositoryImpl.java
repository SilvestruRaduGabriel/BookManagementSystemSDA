package com.sda.ro.silvestruradugabriel.bms.repository;

import com.sda.ro.silvestruradugabriel.bms.model.Book;

public class BookRepositoryImpl extends BaseRepositoryImpl<Book, Integer> implements BookRepository {

    public BookRepositoryImpl() {
        super(Book.class);
    }

    @Override
    public void createBook(Book book) {
        createEntity(book);
    }
}
