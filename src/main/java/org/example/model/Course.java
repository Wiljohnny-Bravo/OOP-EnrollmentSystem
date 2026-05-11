package org.example.model;

public class Course{
    private int courseID;
    private String courseName;
    private String courseProgram;

    //Constructor Chaining
    public Course(){
        this(0);
    }
    public Course(int courseID){
        this(courseID, "Unkown");
    }
    public Course(int courseID, String courseName){
        this(courseID, courseName, "Unknown");

    }
    public Course(int courseID, String courseName, String courseProgram){
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseProgram = courseProgram;
    }

    public int getCourseID(){
        return courseID;
    }
    public void setCourseID(int ID){
        this.courseID = ID;
    }
    public String getCourseName(){
        return courseName;
    }
    public void setCourseName(String name){
        this.courseName = name;
    }
    public String getCourseProgram(){
        return courseProgram;
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
