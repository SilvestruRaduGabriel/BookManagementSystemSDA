package com.sda.ro.silvestruradugabriel.bms.service.exceptions;

public class UserNotFoundException extends Exception {

    private Integer userId;


    public UserNotFoundException(String message) {
        super(message);
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }
}
