package com.sda.ro.silvestruradugabriel.bms.controller;

import com.sda.ro.silvestruradugabriel.bms.model.Author;
import com.sda.ro.silvestruradugabriel.bms.model.User;
import com.sda.ro.silvestruradugabriel.bms.service.UserService;
import com.sda.ro.silvestruradugabriel.bms.service.UserServiceImpl;
import com.sda.ro.silvestruradugabriel.bms.service.exceptions.UserNotFoundException;

import java.util.List;
import java.util.Scanner;

public class UserControllerImpl implements UserController {
    private UserService userService;
    private static final Scanner SCANNER = new Scanner(System.in);

    public UserControllerImpl() {
        this.userService = new UserServiceImpl();

    }

    @Override
    public void createUser() {
        System.out.println("Please insert the User Name:");
        String userName = SCANNER.nextLine();
        System.out.println("Please insert the phone number");
        String phoneNumber = SCANNER.nextLine();

        userService.createUser(userName, phoneNumber);
    }

    @Override
    public void findAll() {
        System.out.println("List of Authors");
        List<User> users = userService.findAll();
        for (User user : users) {
            System.out.println("First name: " + user.getUserName());
            System.out.println("Phone number: " + user.getPhoneNumber());

        }
    }

    @Override
    public void deleteUser() {
        System.out.println("Please insert user id that have to be deleted");
        Integer id = SCANNER.nextInt();
        try {
            userService.deleteUser(id);
        } catch (UserNotFoundException e) {
            System.out.println("User not found!");
        }
    }
}
