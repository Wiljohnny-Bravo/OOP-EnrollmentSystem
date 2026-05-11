package org.example.service;

import org.example.model.Instructor;
import org.example.model.Section;

import java.util.ArrayList;
import java.util.Scanner;

public class IInstructorServiceImpl implements IInstructorService {
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Instructor> instructorList = new ArrayList<>();

    //CREATE
    @Override
    public void addInstructor(Instructor instructor) {
        System.out.println("Enter student: ");
        instructorList.add(instructor);
    }

    @Override
    public void assignToSection(Instructor instructor, Section section) {
        for(int i = 0; i < instructorList.size(); i++){
            if(instructorList.get(i).getID() == instructor.getID()){
                instructorList.get()
            }
        }
    }

    @Override
    public void getInstructorDetails(Instructor instructor) {

    }
}
