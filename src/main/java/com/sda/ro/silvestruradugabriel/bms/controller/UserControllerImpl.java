package com.sda.ro.silvestruradugabriel.bms.controller;

import com.sda.ro.silvestruradugabriel.bms.service.UserService;
import com.sda.ro.silvestruradugabriel.bms.service.UserServiceImpl;

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

        userService.createUser(userName , phoneNumber);
    }
}
