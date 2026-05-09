package org.example.service;

import org.example.model.Department;

import java.util.ArrayList;
import java.util.Scanner;

public class DepartmentRegistrationImpl implements DepartmentRegistration{
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Department> departmentList = new ArrayList<>();

    @Override
    public void saveDepartment(Department department) {
        System.out.print("Enter department name: ");
        departmentList.add(department);
    }

    @Override
    public void displayDepartment(Department department) {
        System.out.println(departmentList);
    }

    @Override
    public void updateDepartment(Department department) {
        for (int i =  0; i < departmentList.size(); i++){
            if(departmentList.get(i).getDepartmentID() == (department.getDepartmentID())){
                System.out.print("Enter department name: ");
                String name = sc.next();

                System.out.println("Enter instructor name: ");
                String instructor = sc.next();


                
                departmentList.set(i, department);

//                departmentList.set(i, new Department(department.getDepartmentID(), name, instructor));
                break;
            }
        }
    }

    @Override
    public String removeDepartment() {
        return "";
    }

//    CREATE
//    @Override
//    public void saveDepartment(Department department){
//        System.out.print("Enter department name: ");
//        departmentList.add(department);
//    }
}
