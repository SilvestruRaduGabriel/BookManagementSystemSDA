package com.sda.ro.silvestruradugabriel.bms.repository;

import com.sda.ro.silvestruradugabriel.bms.model.Department;

public interface DepartmentRepository extends BaseRepository<Department, Integer> {

    void createDepartment(Department department);
}
