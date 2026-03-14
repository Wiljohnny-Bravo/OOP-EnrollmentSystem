package org.example.model;

public class Student extends Person{
    private String program;

    //Constructor Chaining
    public Student(){
        this(0);
    }
    public Student(int id){
        this(id, "Unknown");
    }
    public Student(int id, String name){
        this(id, name, "Unknown");
    }

    @Override
    public void mainTask() {
        System.out.println("Main Task: Study");
    }

    public Student(int id, String name, String program){
        super(id, name);
        this.program = program;
    }
    public String getProgram(){
        return program;
    }
    public void setProgram(String program){
        this.program = program;
    }
    //display used in discussion not by me
    public void display(){
        System.out.println("Student ID: " + getID());
        System.out.println("Student Name: " + getName());
        System.out.println("Program: " + getProgram());
    }
    @Override
    public String toString() {
        return "STUDENT:" +
                "Student ID: " + super.getID() + " || " +
                "Student Name: " + super.getName() + " || " +
                "Program: " + program + "\n ";
    }
}
