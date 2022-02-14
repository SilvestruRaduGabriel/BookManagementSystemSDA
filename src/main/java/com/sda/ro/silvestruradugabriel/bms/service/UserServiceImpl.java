package com.sda.ro.silvestruradugabriel.bms.service;

import com.sda.ro.silvestruradugabriel.bms.model.User;
import com.sda.ro.silvestruradugabriel.bms.repository.UserRepository;
import com.sda.ro.silvestruradugabriel.bms.repository.UserRepositoryImpl;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl() {
        this.userRepository = new UserRepositoryImpl();
    }

    @Override
    public void createUser(String userName, String phoneNumber) {
        User user = new User();
        user.setUserName(userName);
        user.setPhoneNumber(phoneNumber);

        userRepository.createUser(user);
    }
}
