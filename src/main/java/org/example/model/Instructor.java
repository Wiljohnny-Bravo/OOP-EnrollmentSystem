package org.example.model;

import java.util.ArrayList;

public class Instructor extends Person{
//    private ArrayList<Course> course = new ArrayList<>();
    private String course;

    public Instructor(){
        this(0);
    }
    public Instructor(int id){
        this(id, "Unknown");
    }
    public Instructor(int id, String name){
        this(id, name, "Unknown");
    }
    public Instructor(int id, String name, String course){
        super(id, name);
        this.course = course;
    }
    @Override
    public void mainTask() {
        System.out.println("Main Task: Teach");
    }
    public String toString() {
        return "INSTRUCTOR:" +
                "Instructor ID: " + super.getID() + " || " +
                "Instructor Name: " + super.getName() + " || " +
                "Course: " + course + "\n ";
    }

}