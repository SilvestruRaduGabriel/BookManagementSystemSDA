package com.sda.ro.silvestruradugabriel.bms.service;

import com.sda.ro.silvestruradugabriel.bms.service.exceptions.AuthorNotFoundException;
import com.sda.ro.silvestruradugabriel.bms.model.Author;
import com.sda.ro.silvestruradugabriel.bms.model.Book;
import com.sda.ro.silvestruradugabriel.bms.repository.AuthorRepository;
import com.sda.ro.silvestruradugabriel.bms.repository.AuthorRepositoryImpl;
import com.sda.ro.silvestruradugabriel.bms.repository.BookRepository;
import com.sda.ro.silvestruradugabriel.bms.repository.BookRepositoryImpl;

import javax.sound.sampled.Line;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BookServiceImpl implements BookService {

    private BookRepository bookRepository; // cand declar folosesc tot timpul interfata
    private AuthorRepository authorRepository;

    public BookServiceImpl() {
        authorRepository = new AuthorRepositoryImpl();
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

    @Override
    public void createBook(String isbn, String title, String description, Integer authorId) throws AuthorNotFoundException {
        Author author = authorRepository.findById(authorId);
        if (author != null) {
            Book book = new Book();
            book.setIsbn(isbn);
            book.setTitle(title);
            book.setDescription(description);
            book.setAuthor(author);
            bookRepository.createBook(book);
        } else {
            throw new AuthorNotFoundException("Author not found!", authorId);
        }
    }

    @Override
    public void importBooksFromFile() {
        Path bookFileAbsolutePath = Paths.get("C:\\Users\\gabir\\OneDrive\\Documents\\BookManagementSystemSDA\\data\\books.txt");
        try {
            Files.lines(bookFileAbsolutePath)
                    .filter(line -> line != null)
                    .filter(line -> !line.isEmpty())
                    .skip(1)
                    .forEach(line -> {
                        try {
                            String[] elements = line.split("\\|");
                            createBook(elements[0], elements[1], elements[2], Integer.parseInt(elements[3]));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
