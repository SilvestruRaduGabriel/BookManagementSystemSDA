package com.sda.ro.silvestruradugabriel.bms.repository;

import com.sda.ro.silvestruradugabriel.bms.model.Book;
import com.sda.ro.silvestruradugabriel.bms.utils.SessionManager;
import org.hibernate.Session;

public class BookRepositoryImpl extends BaseRepositoryImpl<Book, Integer> implements BookRepository {

    public BookRepositoryImpl() {
        super(Book.class);
    }

    @Override
    public void createBook(Book book) {
        createEntity(book);
    }

    @Override
    public Book findByIdAndLoadReviews(Integer id) {
        Session session = SessionManager.getSessionFactory().openSession();

        Book book= session.find(Book.class, id);
        System.out.println(book.getReviews().size()); // incarcarea datelor in interiorul sesiunii.

        session.close();
        return book;
    }
}
