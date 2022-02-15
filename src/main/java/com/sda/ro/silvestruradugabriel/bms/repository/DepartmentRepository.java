package com.sda.ro.silvestruradugabriel.bms.repository;

import com.sda.ro.silvestruradugabriel.bms.model.Department;

import java.util.List;

public interface DepartmentRepository extends BaseRepository<Department, Integer> {

    void createDepartment(Department department);

    List<Department> findAll();
}
