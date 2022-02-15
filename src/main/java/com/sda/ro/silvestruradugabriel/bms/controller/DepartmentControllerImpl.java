package com.sda.ro.silvestruradugabriel.bms.controller;

import com.sda.ro.silvestruradugabriel.bms.model.Department;
import com.sda.ro.silvestruradugabriel.bms.service.DepartmentService;
import com.sda.ro.silvestruradugabriel.bms.service.DepartmentServiceImpl;
import com.sda.ro.silvestruradugabriel.bms.service.exceptions.DepartmentNotFoundException;

import java.util.List;
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

    @Override
    public void findAll() {
        System.out.println("List of Departments");
        List<Department> departments = departmentService.findAll();
        for (Department department : departments) {
            System.out.println("Department name: " + department.getName());
        }
    }

    @Override
    public void updateDepartment() {
        System.out.println("Please insert the id of department to be updated");
        Integer departmentId = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Please insert the name");
        String name = SCANNER.nextLine();

        try {
            departmentService.updateDepartment(departmentId , name);
        } catch (DepartmentNotFoundException e) {
            System.out.println("Department not found!");
        }
    }

    @Override
    public void deleteDepartment() {
        System.out.println("Please insert the id of department to be deleted");
        Integer departmentId = Integer.parseInt(SCANNER.nextLine());

        try {
            departmentService.deleteDepartment(departmentId);
        } catch (DepartmentNotFoundException e) {
            System.out.println("Department not found!");
        }
    }
}
