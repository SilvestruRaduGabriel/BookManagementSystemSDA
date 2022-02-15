package com.sda.ro.silvestruradugabriel.bms.service.exceptions;

public class DepartmentNotFoundException extends Exception {

    private Integer departmentId;

    public DepartmentNotFoundException(String message) {
        super(message);
        this.departmentId = departmentId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }
}
