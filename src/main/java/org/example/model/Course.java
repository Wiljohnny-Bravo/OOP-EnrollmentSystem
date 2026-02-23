package org.example.model;

public class Course {
    private int courseID;
    private String courseName;
    private String courseProgram;

    //Constructor Chaining
    public Course(){
        this(0);
    }
    public Course(int courseID){
        this(courseID, "Unkown");
        this.courseID = courseID;
    }
    public Course(int courseID, String courseName){
        this(courseID, courseName, "Unknown");
        this.courseID = courseID;
        this.courseName = courseName;
    }
    public Course(int courseID, String courseName, String courseProgram){
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseProgram = courseProgram;
    }

    public int getCourseID(){
        return courseID;
    }
    public String getCourseName(){
        return courseName;
    }
    public String getCourseProgram(){
        return courseProgram;
    }
    public void setCourseName(String name){
        this.courseName = name;
    }
    public void setCourseID(int ID){
        this.courseID = ID;
    }
    public void setCourseProgram(String courseProgram){
        this.courseProgram = courseProgram;
    }

    @Override
    public String toString() {
        return "COURSE:\n" +
                "Course ID: " + courseID + "\n" +
                "Course Name: " + courseName + "\n" +
                "Program: " + courseProgram + "\n";
    }
}
