package com.sda.ro.silvestruradugabriel.bms.utils;

import com.sda.ro.silvestruradugabriel.bms.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionManager extends AbstractSessionManager {

    private static final SessionManager INSTANCE = new SessionManager();

    private SessionManager() {
    }

    public static SessionFactory getSessionFactory() {
        return INSTANCE.getSessionFactory("BMS");
    }

    public static void shutDown() {
        INSTANCE.shutdownSessionManager();
    }

    @Override
    protected void setAnnotatedClasses(Configuration configuration) {
        configuration.addAnnotatedClass(Author.class);
        configuration.addAnnotatedClass(Book.class);
        configuration.addAnnotatedClass(Review.class);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Department.class);
    }
}
