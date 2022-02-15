package com.sda.ro.silvestruradugabriel.bms.repository;

import com.sda.ro.silvestruradugabriel.bms.model.Department;

public class DepartmentRepositoryImpl extends BaseRepositoryImpl<Department, Integer> implements DepartmentRepository {

    public DepartmentRepositoryImpl() {
        super(Department.class);
    }

    @Override
    public void createDepartment(Department department) {
        createEntity(department);
    }
}
