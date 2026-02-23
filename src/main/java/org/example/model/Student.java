package org.example.model;

public class Student {
    private int studentID;
    private String studentName;
    private String program;

    //Constructor Chaining
    public Student(){
        this(0);
    }
    public Student(int studentID){
        this(studentID, "Unknown");
        this.studentID = studentID;
    }
    public Student(int studentID, String studentName){
        this(studentID, studentName, "Unkown");
        this.studentID = studentID;
        this.studentName =studentName;
    }
    public Student(int studentID, String studentName, String program){
        this.studentID = studentID;
        this.studentName = studentName;
        this.program = program;
    }

    public int getStudentID(){
        return studentID;
    }
    public String getStudentName(){
        return studentName;
    }
    public String getProgram(){
        return program;
    }
    public void setName(String name){
        this.studentName= name;
    }
    public void setStudentID(int ID){
        this.studentID = ID;
    }
    public void setProgram(String program){
        this.program = program;
    }
    //display used in discussion not by me
    public void display(){
        System.out.println("Student ID: " + getStudentID());
        System.out.println("Student Name: " + getStudentName());
        System.out.println("Program: " + getProgram());
    }
    @Override
    public String toString() {
        return "STUDENT:" +
                "Student ID: " + studentID + " || " +
                "Student Name: " + studentName + " || " +
                "Program: " + program + "\n ";
    }
}
