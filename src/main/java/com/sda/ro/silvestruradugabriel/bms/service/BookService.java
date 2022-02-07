package com.sda.ro.silvestruradugabriel.bms.service;

import com.sda.ro.silvestruradugabriel.bms.model.Author;

public interface BookService {

    void createBook(String isbn, String title, String description);

}
