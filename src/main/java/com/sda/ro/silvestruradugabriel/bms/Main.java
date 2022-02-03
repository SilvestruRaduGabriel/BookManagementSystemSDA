package com.sda.ro.silvestruradugabriel.bms;

import com.sda.ro.silvestruradugabriel.bms.controller.AuthorController;
import com.sda.ro.silvestruradugabriel.bms.controller.AuthorControllerImpl;
import com.sda.ro.silvestruradugabriel.bms.controller.BookController;
import com.sda.ro.silvestruradugabriel.bms.controller.BookControllerImpl;
import com.sda.ro.silvestruradugabriel.bms.utils.SessionManager;

import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        BookController bookController = new BookControllerImpl();
        AuthorController authorController = new AuthorControllerImpl();
        System.out.println("BookManagementSystem is starting");
        String option = null;
        do {
            printMenu();
            System.out.println("Please insert your option: ");
            option = SCANNER.nextLine();
            switch (option) {
                case "1":
                    bookController.createBook();
                    break;
                case "2":
                    authorController.createAuthor();
                    break;
                case "Exit":
                    System.out.println("Bye bye");
                    break;
                default:
                    System.out.println("Option is not valid!");

            }
        } while (option == null || !option.equals("Exit"));


        SessionManager.shutDown();
    }

    private static void printMenu() {
        System.out.println("Menu :");
        System.out.println("1 -> Create book:");
        System.out.println("2 -> Create author:");
        System.out.println("Exit -> Close the application");
    }
}
