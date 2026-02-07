package org.example;

public class Student {
    private String studentID;
    private String studentName;
    private String program;

    public Student(){

    }
    public String getStudentID(){
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
    public void setStudentID(String ID){
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
        return "STUDENT:\n" +
                "Student ID: " + studentID + "\n" +
                "Student Name: " + studentName + "\n" +
                "Program: " + program + "\n";
    }
}
