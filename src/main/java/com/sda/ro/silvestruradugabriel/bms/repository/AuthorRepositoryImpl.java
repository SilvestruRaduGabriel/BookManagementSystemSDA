package com.sda.ro.silvestruradugabriel.bms.repository;

import com.sda.ro.silvestruradugabriel.bms.model.Author;
import com.sda.ro.silvestruradugabriel.bms.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AuthorRepositoryImpl implements AuthorRepository {
    @Override
    public void createAuthor(Author author) {
        Session session = SessionManager.getSessionFactory().openSession();

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction(); // Incepe tranzactia pe baza de date
            session.save(author); // aici e querry-ul care il vom trimite la baza de date adica authorul creeat in controller si service
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