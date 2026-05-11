package org.example.service;

import org.example.model.Department;

import java.util.List;

public interface DepartmentRegistration {
    void addDepartment(Department department);
    void displayDepartment(Department department);
    void updateDepartment(Department department);
    String removeDepartment();
    List<Department> getDepartmentList();
}
