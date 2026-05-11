package org.example.service;

import org.example.model.Instructor;
import org.example.model.Section;

import java.util.ArrayList;
import java.util.List;
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
        boolean found = false;
        for(int i = 0; i < instructorList.size(); i++){
            if(instructorList.get(i).getID() == instructor.getID()){
                instructorList.get(i).setSection(section);
            }
            System.out.println("Instructor " + instructorList.get(i).getPersonName() +
                    " ahs been assigned to Section: " + section.getSectionName());
            found = true;
            break;
        }
        if(!found){
            System.out.println("Error: Instructor ID " + instructor.getID() + " not found.");
        }
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return instructorList;
    }

    @Override
    public void getInstructorDetails(Instructor instructor) {
        for (Instructor i : instructorList) {
            if (i.getID() == instructor.getID()) {
                System.out.println(i.toString());
                return;
            }
        }
        System.out.println("Instructor not found.");
    }
}
