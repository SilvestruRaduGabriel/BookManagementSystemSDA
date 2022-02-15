package com.sda.ro.silvestruradugabriel.bms.service;

import com.sda.ro.silvestruradugabriel.bms.model.Department;
import com.sda.ro.silvestruradugabriel.bms.repository.DepartmentRepository;
import com.sda.ro.silvestruradugabriel.bms.repository.DepartmentRepositoryImpl;

public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl() {
        this.departmentRepository = new DepartmentRepositoryImpl();
    }

    @Override
    public void createDepartment(String name) {
        Department department = new Department();
        department.setName(name);

        departmentRepository.createDepartment(department);
    }
}
