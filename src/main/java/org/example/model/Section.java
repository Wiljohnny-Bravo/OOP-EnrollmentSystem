package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Section {
    private int sectionID;
    private String sectionName;
    private int maxCapacity;
    private ArrayList<Student> enrolledStudents;
    private Instructor instructor;

    public Section(){
        this(0);
    }
    public Section(int sectionID){
        this(sectionID, "Unknown");
    }
    public Section(int sectionID, String sectionName){
        this(sectionID, sectionName, 35);
    }
    public Section(int sectionID, String sectionName, int maxCapacity){
        this.sectionID = sectionID;
        this.sectionName = sectionName;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = new ArrayList<>();
    }

    public int getSectionID(){
        return sectionID;
    }

    public void setSectionID(int sectionID) {
        this.sectionID = sectionID;
    }
    public String getSectionName(){
        return sectionName;
    }
    public void setSectionName(String sectionName){
        this.sectionName = sectionName;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public ArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public boolean isFull() {
        return enrolledStudents.size() >= maxCapacity;
    }

    @Override
    public String toString() {
        return String.format("Section [ID: %d | Name: %s | Capacity: %d/%d]",
                sectionID, sectionName, enrolledStudents.size(), maxCapacity);
    }
}
