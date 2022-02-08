package com.sda.ro.silvestruradugabriel.bms;

public enum MenuOption { // un enum extinde clasa enum deja e ca si cum as scrie public class MenuOption extend Enum.
    CREATE_BOOK("1", "Create Book"),
    CREATE_AUTHOR("2", "Create Author"),
    CREATE_REVIEW("3", "Create Review"),
    CREATE_BOOK_WITH_AUTHOR("4", "Create book with existing Author"),
    VIEW_ALL_AUTHOR("5", "View all authors"),
    UPDATE_AUTHOR("6", "Update author"),
    DELETE_AUTHOR("7", "Delete author"),
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
