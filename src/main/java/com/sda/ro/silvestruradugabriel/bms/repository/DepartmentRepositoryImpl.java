package com.sda.ro.silvestruradugabriel.bms.repository;

import com.sda.ro.silvestruradugabriel.bms.model.Department;
import com.sda.ro.silvestruradugabriel.bms.utils.SessionManager;
import org.hibernate.Session;

import java.util.List;

public class DepartmentRepositoryImpl extends BaseRepositoryImpl<Department, Integer> implements DepartmentRepository {

    public DepartmentRepositoryImpl() {
        super(Department.class);
    }

    @Override
    public void createDepartment(Department department) {
        createEntity(department);
    }

    @Override
    public List<Department> findAll() {
        Session session = SessionManager.getSessionFactory().openSession();
        List<Department> departments = session.createQuery("from Department " , Department.class).list();
        session.close();
        return departments;
    }
}
