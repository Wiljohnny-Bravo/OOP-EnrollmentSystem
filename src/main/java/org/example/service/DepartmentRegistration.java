package org.example.service;

import org.example.model.Department;

public interface DepartmentRegistration {
    void saveDepartment(Department department);
    void displayDepartment(Department department);
    void updateDepartment(Department department);
    String removeDepartment();
}
