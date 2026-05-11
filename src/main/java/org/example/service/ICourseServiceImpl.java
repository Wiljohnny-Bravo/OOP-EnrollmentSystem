package org.example.service;

import org.example.model.Course;

import java.util.ArrayList;
import java.util.Scanner;
public class ICourseServiceImpl implements ICourseService {
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Course> courseList = new ArrayList<>();

    //CREATE
    @Override
    public void saveCourse(Course course){
        courseList.add(course);
    }

    //READ
    @Override
    public void displayAllCourse(){
        System.out.println(courseList);
    }

    //UPDATE
    @Override
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

    @Override
    public String removeCourse() {
        return "";
    }

    public String removeCourse(Course course){
        for(int i = 0; i < courseList.size(); i++){
            if(courseList.get(i).getCourseID() == (course.getCourseID())){
                courseList.remove(i);
                return "Deleted Successfully";
            }
        }
        return "Error Found.";
    }
}
