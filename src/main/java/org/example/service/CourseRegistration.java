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
    public void updateCourse(Course course){
        for (int i =  0; i < courseList.size(); i++){
            if(courseList.get(i).getCourseID() == (course.getCourseID())){
                System.out.print("Enter Course name: ");
                String name = sc.next();

                System.out.println("Enter Course program: ");
                String program = sc.next();

                courseList.set(i, course);

                courseList.set(i, new Course(course.getCourseID(), name, program));
                break;
            }
        }
    }
    public String removeCourse(Course course){
        for(int i = 0; i < courseList.size(); i++){
            if(courseList.get(i).getCourseID() == (course.getCourseID())){
                courseList.remove(i);
                return "Deleted Successfully";
            }
        }
        return "Error";
    }
}
