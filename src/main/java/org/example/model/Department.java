package org.example.model;

import java.util.List;

public class Department {
    private int departmentID;
    private String departmentName;
    private List<Instructor> instructorList;

    public Department(int id, String departmentName, List<Instructor> instructorList){
        this.departmentID = id;
        this.departmentName = departmentName;
        this.instructorList = instructorList;
    }

    public int getDepartmentID(){
        return departmentID;
    }
    public void setDepartmentID(int ID){
        this.departmentID = ID;
    }
    public String getDepartmentName(){
        return departmentName;
    }
    public void setDepartmentName(String departmentName){
        this.departmentName = departmentName;
    }
    public String getDepartmentInstructor(){
        return instructorList.toString();
    }
    public void setDepartmentInstructor(List instructorList){
        this.getDepartmentInstructor();
    }

    public List<Instructor> getInstructorList() {
    return instructorList;
    }
}
