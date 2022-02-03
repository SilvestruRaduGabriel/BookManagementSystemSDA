package com.sda.ro.silvestruradugabriel.bms.repository;

import com.sda.ro.silvestruradugabriel.bms.model.Book;
import com.sda.ro.silvestruradugabriel.bms.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

//Impl ( Implementare)
public class BookRepositoryImpl implements BookRepository {
    @Override
    public void createBook(Book book) {
        // Folosind session realizam conectarea la baza de date
        //cu getSessionFactory pot sa generez
        Session session = SessionManager.getSessionFactory().openSession();

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction(); // Incepe tranzactia pe baza de date
            session.save(book); // aici e querry-ul
            transaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }
}
