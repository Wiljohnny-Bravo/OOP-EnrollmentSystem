package org.example.service;

import org.example.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IStudentServiceImpl implements IStudentService {
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Student> studentList = new ArrayList<>();

    //CREATE
    @Override
    public void addStudent(Student student){
        System.out.println("Enter student: ");
        studentList.add(student);
    }

    //READ
    @Override
    public void displayAllStudent(){
        System.out.println(studentList);
    }

    //UPDATE
    @Override
    public void updateStudent(Student student){
        for (int i = 0; i < studentList.size(); i++){
            if(studentList.get(i).getID() == (student.getID())){
                System.out.print("Enter name: ");
                String name = sc.nextLine();

                System.out.print("Enter program: ");
                String program = sc.nextLine();

                studentList.set(i, student);

                studentList.set(i, new Student(student.getID(), name, program));
                break;
            }
        }
    }

    //DELETE
    @Override
    public String removeStudent(Student student){
        for(int i = 0; i < studentList.size(); i++){
            if(studentList.get(i).getID() == (student.getID())){
                studentList.remove(i);
                return "Deleted Successfully";
            }
        }
        return "Error Found.";
    }

    public ArrayList<Student> getStudentList() {
        return this.studentList;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentList;
    }

    @Override
    public Student getStudentById(int id) {
        for (Student s : studentList) {
            if (s.getID() == id) return s;
        }
        return null; // Handle this in Main
    }
}
