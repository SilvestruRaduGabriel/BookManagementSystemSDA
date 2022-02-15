package com.sda.ro.silvestruradugabriel.bms.controller;

import com.sda.ro.silvestruradugabriel.bms.service.DepartmentService;
import com.sda.ro.silvestruradugabriel.bms.service.DepartmentServiceImpl;

import java.util.Scanner;

public class DepartmentControllerImpl implements DepartmentController {

    private static final Scanner SCANNER = new Scanner(System.in);
    private DepartmentService departmentService;

    public DepartmentControllerImpl() {
        this.departmentService = new DepartmentServiceImpl();
    }

    @Override
    public void createUser() {
        System.out.println("Please insert the name");
        String name = SCANNER.nextLine();

        departmentService.createDepartment(name);

    }
}
