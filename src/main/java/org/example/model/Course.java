package org.example.model;

public class Course {
    private String courseID;
    private String courseName;
    private String program;

    public String getCourseID(){
        return courseID;
    }
    public String getCourseName(){
        return courseName;
    }
    public String getProgram(){
        return program;
    }
    public void setCourseName(String name){
        this.courseName = name;
    }
    public void setCourseID(String ID){
        this.courseID = ID;
    }
    public void setProgram(String program){
        this.program = program;
    }

    @Override
    public String toString() {
        return "COURSE:\n" +
                "Course ID: " + courseID + "\n" +
                "Course Name: " + courseName + "\n" +
                "Program: " + program + "\n";
    }
}
