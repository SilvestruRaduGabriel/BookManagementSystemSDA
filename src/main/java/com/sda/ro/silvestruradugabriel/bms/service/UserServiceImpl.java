package com.sda.ro.silvestruradugabriel.bms.service;

import com.sda.ro.silvestruradugabriel.bms.model.User;
import com.sda.ro.silvestruradugabriel.bms.repository.UserRepository;
import com.sda.ro.silvestruradugabriel.bms.repository.UserRepositoryImpl;
import com.sda.ro.silvestruradugabriel.bms.service.exceptions.UserNotFoundException;

import java.util.List;

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

    @Override
    public List<User> findAll() {
        List<User> usersList= userRepository.findAll();
        return usersList;
    }

    @Override
    public void deleteUser(Integer id) throws UserNotFoundException {
        User user = userRepository.findById(id);
        if (user != null) {
            userRepository.delete(user);
        }else {
            throw new UserNotFoundException("User not found!");
        }
    }
}
