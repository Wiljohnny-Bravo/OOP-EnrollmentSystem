package org.example;
import org.example.model.Course;
import org.example.model.Student;
import org.example.service.CourseRegistration;
import org.example.service.StudentRegistration;

import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static StudentRegistration studentRegistration = new StudentRegistration();
    static CourseRegistration courseRegistration = new CourseRegistration();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;

        do {
            displayChoice();
            choice = sc.nextInt();
            sc.nextLine();
            System.out.println("===========================================================================================");
            switch (choice){
                case 1:
                    studentSwitch();
                    break;
                case 2:
                    courseSwitch();
                    break;
                case 3:
                    System.out.println("Exiting.....");
                    break;
            }
        }while(choice != 3);
    }
    public static void displayChoice(){
        System.out.print("===========================================================================================" +
                "\n[1] Student" +
                "\n[2] Course" +
                "\n[3] Exit" +
                "\nEnter choice: ");
    }
    public static void studentSwitch(){
        int choice;

        do {
            displayCommands();
            choice = sc.nextInt();
            sc.nextLine();
            System.out.println("===========================================================================================");
            switch (choice){
                case 1:
                    saveStudent();
                    break;
                case 2:
                    studentRegistration.displayALl();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    removeStudent();
                    break;
                case 5:
                    System.out.println("Exiting.....");
                    break;
            }
        }while(choice != 5);
    }
    public static void courseSwitch(){
        int choice;
        do {
            displayCommands();
            choice = sc.nextInt();
            System.out.println("===========================================================================================");
            switch(choice){
                case 1:
                    saveCourse();
                    break;
                case 2:
                    courseRegistration.displayAll();
                    break;
                case 3:
                    updateCourse();
                    break;
                case 4:
                    removeCourse();
                    break;
                case 5:
                    break;
            }
        }while(choice != 5);
    }
    public static void displayCommands(){
        System.out.print("===========================================================================================" +
                "[\n1] Save Student" +
                "\n[2] Display Student" +
                "\n[3] Update Student" +
                "\n[4] Remove Student" +
                "\n[5] Exit" +
                "\nEnter Command: ");
    }

    public static void saveStudent(){
        System.out.println("===========================================================================================");
        System.out.print("Enter Student ID: ");
        int sID = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String sName = sc.nextLine();

        System.out.print("Enter Student Program: ");
        String sProgram = sc.nextLine();

        Student newStudent = new Student(sID, sName, sProgram);
        studentRegistration.saveStudent(newStudent);
        System.out.println("Student Saved!");
        System.out.println("===========================================================================================");
    }

    public static void updateStudent(){
        System.out.println("===========================================================================================");
        System.out.print("Enter Student ID to update:");
        int updateStudentID = sc.nextInt();

        studentRegistration.updateStudent(new Student(updateStudentID));
        System.out.println("===========================================================================================");
    }

    public static void removeStudent(){
        System.out.println("===========================================================================================");
        System.out.print("Enter Student ID to remove:");
        int removeStudentID = sc.nextInt();

        studentRegistration.removeStudent(new Student(removeStudentID));
        System.out.println("===========================================================================================");
    }
    public static void saveCourse(){
        System.out.println("===========================================================================================");
        System.out.print("Enter Course ID: ");
        int cID = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course Name: ");
        String cName = sc.nextLine();

        System.out.print("Enter Course Program: ");
        String cProgram = sc.nextLine();

        Course newCourse = new Course(cID, cName, cProgram);
        courseRegistration.saveCourse(newCourse);
        System.out.println("===========================================================================================");
    }

    public static void updateCourse(){
        System.out.println("===========================================================================================");
        System.out.print("Enter Student ID to update: ");
        int updateCourseID = sc.nextInt();
        courseRegistration.updateCourse(new Course(updateCourseID));
        System.out.println("===========================================================================================");
    }

    public static void removeCourse(){
        System.out.println("===========================================================================================");
        System.out.print("Enter Student ID to update: ");
        int removeCourseID = sc.nextInt();
        courseRegistration.updateCourse(new Course(removeCourseID));
        System.out.println("===========================================================================================");
    }
}