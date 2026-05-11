package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private int departmentID;
    private String departmentName;
    private List<Instructor> instructorList;
    private List<Section> sectionList;

    public Department(int departmentID, String departmentName) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.instructorList = new ArrayList<>();
        this.sectionList = new ArrayList<>();
    }

    public Department(int departmentID, String departmentName, List<Instructor> instructorList) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.instructorList = (instructorList != null) ? instructorList : new ArrayList<>();
        this.sectionList = new ArrayList<>();
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
    public void setInstructorList(List<Instructor> instructorList) {
        this.instructorList = instructorList;
    }
    public List<Section> getSectionList() {
        return sectionList;
    }
    public void addSection(Section section) {
        this.sectionList.add(section);
    }
    public void addInstructor(Instructor instructor) {
        this.instructorList.add(instructor);
    }

    @Override
    public String toString() {
        return "Department:" +
                "Department ID: " + departmentID +
                "\nDepartment Name: '" + departmentName + '\'' +
                "\n" + instructorList +
                ", sectionList=" + sectionList +
                '}';
    }
}
