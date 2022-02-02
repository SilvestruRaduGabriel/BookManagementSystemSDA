package com.sda.ro.silvestruradugabriel.bms;

import com.sda.ro.silvestruradugabriel.bms.model.Author;
import com.sda.ro.silvestruradugabriel.bms.model.Book;
import com.sda.ro.silvestruradugabriel.bms.model.Review;
import com.sda.ro.silvestruradugabriel.bms.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("BookingManagementSystem is starting.");
        SessionFactory sessionFactory = SessionManager.getSessionFactory();

        Session session = sessionFactory.openSession(); // am deschis sesiunea

        Author author = new Author();
        author.setFirstName("Creanga");
        author.setLastName("Ion");
        session.save(author);

        Book book = new Book();
        book.setAuthor(author);
        book.setTitle("Amintiri din Copilarie");
        book.setIsbn("123323-bms");
        book.setDescription("Povesti pentru copii");
        session.save(book);

        Review review = new Review();
        review.setBook(book);
        review.setComment("Nice book");
        review.setScore(10);
        session.save(review);

        session.close();

        SessionManager.shutDown();
    }
}
