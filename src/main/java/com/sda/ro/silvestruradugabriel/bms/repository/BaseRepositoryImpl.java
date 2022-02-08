package com.sda.ro.silvestruradugabriel.bms.repository;

import com.sda.ro.silvestruradugabriel.bms.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BaseRepositoryImpl<T, ID> implements BaseRepository<T, ID> {

    private final Class<T> clazz;

    public BaseRepositoryImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void createEntity(T entity) {
        Session session = SessionManager.getSessionFactory().openSession();

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction(); // Incepe tranzactia pe baza de date
            session.save(entity); // aici e querry-ul care il vom trimite la baza de date adica authorul creeat in controller si service
            transaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }

    @Override
    public T findById(ID id) {
        Session session = SessionManager.getSessionFactory().openSession();
        T entity = session.find(clazz, id); // Author.class l-am inlocuit cu clazz.
        session.close();
        return entity;
    }

}
