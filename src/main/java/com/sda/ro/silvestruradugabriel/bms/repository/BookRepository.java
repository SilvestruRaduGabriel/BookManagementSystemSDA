package com.sda.ro.silvestruradugabriel.bms.repository;

import com.sda.ro.silvestruradugabriel.bms.model.Book;

public interface BookRepository extends BaseRepository<Book, Integer> {

    void createBook(Book book); // Ii dam parametrii

}
