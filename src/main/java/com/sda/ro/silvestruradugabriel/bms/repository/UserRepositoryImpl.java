package com.sda.ro.silvestruradugabriel.bms.repository;

import com.sda.ro.silvestruradugabriel.bms.model.User;
import com.sda.ro.silvestruradugabriel.bms.utils.SessionManager;
import org.hibernate.Session;

import java.util.List;

public class UserRepositoryImpl extends BaseRepositoryImpl<User, Integer> implements UserRepository {

    public UserRepositoryImpl() {
        super(User.class);
    }

    @Override
    public void createUser(User user) {
        createEntity(user);
    }

    @Override
    public List<User> findAll() {
        Session session = SessionManager.getSessionFactory().openSession();
        List<User> users = session.createQuery("from User", User.class).list();
        session.close();
        return users;
    }
}
