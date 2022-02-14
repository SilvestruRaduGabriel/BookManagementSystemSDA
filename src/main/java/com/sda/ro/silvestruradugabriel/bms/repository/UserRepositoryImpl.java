package com.sda.ro.silvestruradugabriel.bms.repository;

import com.sda.ro.silvestruradugabriel.bms.model.User;

public class UserRepositoryImpl extends BaseRepositoryImpl<User, Integer> implements UserRepository {

    public UserRepositoryImpl() {
        super(User.class);
    }

    @Override
    public void createUser(User user) {
        createEntity(user);
    }
}
