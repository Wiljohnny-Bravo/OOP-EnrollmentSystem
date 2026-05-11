package org.example.service;

import org.example.model.Department;
import java.util.ArrayList;

public class DepartmentRegistrationImpl implements DepartmentRegistration {
    private ArrayList<Department> departmentList = new ArrayList<>();

    @Override
    public void addDepartment(Department department) {
        // Logic should only handle data storage
        departmentList.add(department);
    }

    @Override
    public void displayDepartment(Department department) {
        System.out.println(departmentList);
    }

    @Override
    public void updateDepartment(Department department) {
        for (int i = 0; i < departmentList.size(); i++) {
            if (departmentList.get(i).getDepartmentID() == department.getDepartmentID()) {
                departmentList.set(i, department);
                break;
            }
        }
    }

    @Override
    public String removeDepartment() {
        // Implementation as needed for deletion
        return "Department logic processed.";
    }

    @Override
    public ArrayList<Department> getDepartmentList() {
        return departmentList;
    }
}