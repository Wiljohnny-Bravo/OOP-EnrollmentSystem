package org.example.service;

import org.example.model.Course;

import java.util.ArrayList;
import java.util.Scanner;
public class CourseRegistration {
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Course> courseList = new ArrayList<>();

    //CREATE
    public void saveCourse(Course course){
        courseList.add(course);
    }
    //READ
    public void displayAll(){
        System.out.println(courseList);
    }

    //UPDATE
}
