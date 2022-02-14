package com.sda.ro.silvestruradugabriel.bms.service;

import com.sda.ro.silvestruradugabriel.bms.model.User;
import com.sda.ro.silvestruradugabriel.bms.service.exceptions.UserNotFoundException;

import java.util.List;

public interface UserService {
    void createUser(String userName, String phoneNumber);

    List<User> findAll();

    void deleteUser(Integer id) throws UserNotFoundException;
}
