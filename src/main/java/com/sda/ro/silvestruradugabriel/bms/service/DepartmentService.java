package com.sda.ro.silvestruradugabriel.bms.service;

import com.sda.ro.silvestruradugabriel.bms.model.Department;
import com.sda.ro.silvestruradugabriel.bms.service.exceptions.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {

    void createDepartment(String name);

    List<Department> findAll();

    void updateDepartment(Integer id, String name) throws DepartmentNotFoundException;

    void deleteDepartment(Integer id) throws DepartmentNotFoundException;

}
