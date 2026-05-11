package org.example.service;

import org.example.model.Department;
import org.example.model.Instructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentRegistrationImpl implements DepartmentRegistration{
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Department> departmentList = new ArrayList<>();
    private List<Instructor> instructorList;

    @Override
    public void saveDepartment(Department department) {
        System.out.print("Enter department name: ");
        departmentList.add(department);
    }

    @Override
    public void displayDepartment(Department department) {
        System.out.println(departmentList);
    }

    public void setInstructorList(List<Instructor> instructorList) {
        this.instructorList = instructorList;
    }

    public List<Instructor> getInstructorList() {
        return instructorList;
    }

    @Override
    public void updateDepartment(Department department) {
        for (int i =  0; i < departmentList.size(); i++){
            if(departmentList.get(i).getDepartmentID() == (department.getDepartmentID())){
                System.out.print("Enter new Department Name: ");
                String newName = sc.nextLine();

                List<Instructor> existingInstructors = departmentList.get(i).getInstructorList();

                departmentList.set(i, new Department(department.getDepartmentID(), newName, existingInstructors));

                System.out.println("Department updated successfully.");
                break;
            }
        }
    }

    @Override
    public String removeDepartment() {
        System.out.print("Enter Department ID to remove: ");
        int idToRemove = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < departmentList.size(); i++) {
            if (departmentList.get(i).getDepartmentID() == idToRemove) {
                departmentList.remove(i);
                return "Department " + idToRemove + " removed successfully.";
            }
        }
        return "Error: Department ID not found.";
    }

    @Override
    public ArrayList<Department> getDepartmentList(){
        return departmentList;
    }

//    CREATE
//    @Override
//    public void saveDepartment(Department department){
//        System.out.print("Enter department name: ");
//        departmentList.add(department);
//    }
}
