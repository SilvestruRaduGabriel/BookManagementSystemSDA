package com.sda.ro.silvestruradugabriel.bms.repository;

import com.sda.ro.silvestruradugabriel.bms.model.User;

import java.util.List;

public interface UserRepository extends BaseRepository<User, Integer> {

    void createUser(User user);

    List<User> findAll();

}
