package org.example.service;

import org.example.model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentRegistration {
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Student> studentList = new ArrayList<>();

    //CREATE
    public void saveStudent(Student student){
        System.out.println("Enter student: ");
        studentList.add(student);
    }

    //READ
    public void displayALl(){
        System.out.println(studentList);
    }

    //UPDATE
    public void updateStudent(Student student){
        for (int i = 0; i < studentList.size(); i++){
            if(studentList.get(i).getStudentID() == (student.getStudentID())){
                System.out.print("Enter name: ");
                String name = sc.nextLine();

                System.out.print("Enter program: ");
                String program = sc.nextLine();

                studentList.set(i, student);

                studentList.set(i, new Student(student.getStudentID(), name, program));
                break;
            }
        }
    }

    //REMOVE
    public String removeStudent(Student student){
        for(int i = 0; i < studentList.size(); i++){
            if(studentList.get(i).getStudentID() == (student.getStudentID())){
                studentList.remove(i);
                return "Deleted Successfully";
            }
        }
        return "Error Found.";
    }
}
