package com.sda.ro.silvestruradugabriel.bms.repository;

import com.sda.ro.silvestruradugabriel.bms.model.Author;
import com.sda.ro.silvestruradugabriel.bms.model.Book;
import com.sda.ro.silvestruradugabriel.bms.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AuthorRepositoryImpl extends BaseRepositoryImpl<Author, Integer> implements AuthorRepository {


    public AuthorRepositoryImpl() {
        super(Author.class);
    }

    @Override
    public void createAuthor(Author author) {
        createEntity(author);
    }

    @Override
    public List<Author> findAll() {
        Session session = SessionManager.getSessionFactory().openSession();
        List<Author> authors = session.createQuery("from Author", Author.class).list();
        session.close();
        return authors;
    }
}