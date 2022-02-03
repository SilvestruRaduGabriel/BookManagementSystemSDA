package com.sda.ro.silvestruradugabriel.bms.service;

import com.sda.ro.silvestruradugabriel.bms.model.Book;
import com.sda.ro.silvestruradugabriel.bms.repository.BookRepository;
import com.sda.ro.silvestruradugabriel.bms.repository.BookRepositoryImpl;

public class BookServiceImpl implements BookService {

    private  BookRepository bookRepository; // cand declar folosesc tot timpul interfata

    public BookServiceImpl() {
        bookRepository = new BookRepositoryImpl();
    }

    @Override
    public void createBook(String isbn, String title, String description) {
        Book book = new Book();
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setDescription(description);

        bookRepository.createBook(book);
    }
}
