package com.sda.ro.silvestruradugabriel.bms.service;

import com.sda.ro.silvestruradugabriel.bms.model.Department;
import com.sda.ro.silvestruradugabriel.bms.repository.DepartmentRepository;
import com.sda.ro.silvestruradugabriel.bms.repository.DepartmentRepositoryImpl;
import com.sda.ro.silvestruradugabriel.bms.service.exceptions.DepartmentNotFoundException;

import java.util.List;

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

    @Override
    public List<Department> findAll() {
        List<Department> departmentList = departmentRepository.findAll();
        return departmentList;
    }

    @Override
    public void updateDepartment(Integer id, String name) throws DepartmentNotFoundException {
        Department department = departmentRepository.findById(id);
        if (department != null) {
            department.setId(id);
            department.setName(name);
            departmentRepository.update(department);
        }else {
            throw new DepartmentNotFoundException("Department not found!");
        }
    }

    @Override
    public void deleteDepartment(Integer id) throws DepartmentNotFoundException {
        Department department = departmentRepository.findById(id);
        if (department != null) {
            departmentRepository.delete(department);
        }else {
            throw new DepartmentNotFoundException("Department not found!");
        }
    }
}
