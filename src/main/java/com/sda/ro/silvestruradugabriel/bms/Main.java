package com.sda.ro.silvestruradugabriel.bms;

import com.sda.ro.silvestruradugabriel.bms.controller.AuthorController;
import com.sda.ro.silvestruradugabriel.bms.controller.AuthorControllerImpl;
import com.sda.ro.silvestruradugabriel.bms.controller.BookController;
import com.sda.ro.silvestruradugabriel.bms.controller.BookControllerImpl;
import com.sda.ro.silvestruradugabriel.bms.service.AuthorService;
import com.sda.ro.silvestruradugabriel.bms.service.AuthorServiceImpl;
import com.sda.ro.silvestruradugabriel.bms.service.BookService;
import com.sda.ro.silvestruradugabriel.bms.service.BookServiceImpl;
import com.sda.ro.silvestruradugabriel.bms.utils.SessionManager;
import org.hibernate.Session;

import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        SessionManager.getSessionFactory(); // asa facem sa apara initializarea la inceput.

//        AuthorService authorService = new AuthorServiceImpl();
//        authorService.importAuthorsFromFile();

//        BookService bookService = new BookServiceImpl();
//        bookService.importBooksFromFile();

        BookController bookController = new BookControllerImpl();
        AuthorController authorController = new AuthorControllerImpl();
        System.out.println("BookManagementSystem is starting");
        String option = null;
        do {
            printMenu();
            System.out.println("Please insert your option: ");
            option = SCANNER.nextLine();
            MenuOption menuOption = findByOption(option);
//            if (menuOption == null) {
//                System.out.println("Option is not valid");
//            } else {      E mult mai ok cu UNDEFINED.
            switch (menuOption) {
                case CREATE_BOOK:
                    bookController.createBook();
                    break;
                case CREATE_AUTHOR:
                    authorController.createAuthor();
                    break;
                case CREATE_BOOK_WITH_AUTHOR:
                    bookController.createBookWithAuthor();
                    break;
                case VIEW_ALL_AUTHOR:
                    authorController.viewAllAuthors();
                    break;
                case UPDATE_AUTHOR:
                    authorController.updateAuthor();
                    break;
                case DELETE_AUTHOR:
                    authorController.deleteAuthor();
                    break;
                case EXIT:
                    System.out.println("Bye bye");
                    break;
                default:
                    System.out.println("Option is not valid!");


            }
//            }
        } while (option == null || !option.equals("Exit"));
        SessionManager.shutDown();
    }


    private static void printMenu() {
        System.out.println("Menu :");
//        MenuOption menuOption = MenuOption.CREATE_BOOK; E una dintre metode pentru a asigna un ENUM.
        for (MenuOption menuOption : MenuOption.values()) {
            if (!menuOption.equals(MenuOption.UNDEFINED)) {
                System.out.println(menuOption.getOption() + " -> " + menuOption.getDescription());
            }
        }
    }

    public static MenuOption findByOption(String option) {
        for (MenuOption menuOption : MenuOption.values()) {
            if (menuOption.getOption().equals(option)) {
                return menuOption;
            }
        }
        return MenuOption.UNDEFINED;
    }
}
