package com.sda.ro.silvestruradugabriel.bms;

public enum MenuOption { // un enum extinde clasa enum deja e ca si cum as scrie public class MenuOption extend Enum.
    CREATE_BOOK("1", "Create Book"),
    CREATE_AUTHOR("2", "Create Author"),
    CREATE_REVIEW("3", "Create Review"),
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