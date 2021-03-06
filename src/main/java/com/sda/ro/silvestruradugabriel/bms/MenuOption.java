package com.sda.ro.silvestruradugabriel.bms;

public enum MenuOption { // un enum extinde clasa enum deja e ca si cum as scrie public class MenuOption extend Enum.
    CREATE_BOOK("1", "Create Book"),
    CREATE_AUTHOR("2", "Create Author"),
    CREATE_REVIEW("3", "Create Review"),
    CREATE_BOOK_WITH_AUTHOR("4", "Create book with existing Author"),
    VIEW_ALL_AUTHOR("5", "View all authors"),
    UPDATE_AUTHOR("6", "Update author"),
    DELETE_AUTHOR("7", "Delete author"),
    ADD_REVIEW("8", "Add review"),
    VIEW_REVIEW("9", "View review"),
    CREATE_USER("10", "Create user"),
    VIEW_ALL_USERS("11", "View all users"),
    DELETE_USER("12", "Delete user"),
    UPDATE_USER("13", "Update user"),
    CREATE_DEPARTMENT("14", "Create user"),
    VIEW_DEPARTMENT("15", "View departments"),
    UPDATE_DEPARTMENT("16", "Update department"),
    DELETE_DEPARTMENT("17", "Delete department"),
    EXIT("Exit", "Close the application"),
    UNDEFINED("" , "Option not found!");

    private final String option;
    private final String description;

    MenuOption(String option, String description) { // constructorul e by default private.
        this.option = option;
        this.description = description;
    }

    public String getOption() {
        return option;
    }

    public String getDescription() {
        return description;
    }
}
