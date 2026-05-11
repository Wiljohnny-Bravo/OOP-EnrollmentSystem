package org.example;
import org.example.model.Course;
import org.example.model.Instructor;
import org.example.model.Section;
import org.example.model.Student;
import org.example.service.*;

import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static IStudentServiceImpl studentReg = new IStudentServiceImpl();
    static ICourseServiceImpl courseReg = new ICourseServiceImpl();
    static IInstructorServiceImpl instructorReg = new IInstructorServiceImpl();
    static DepartmentRegistrationImpl deptReg = new DepartmentRegistrationImpl();
    static IEnrollmentService enrollService = new IEnrollmentServiceImpl();

    static Registrar registrar = new Registrar(studentReg, courseReg, instructorReg, deptReg, enrollService);

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Student student =  new Student();
        Instructor instructor =  new Instructor();
        student.mainTask();
        instructor.mainTask();

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
                    enrollStuToSec();
                    break;
                case 4:
                    assignInstToSec();
                    break;
                case 5:
                    viewHierarchy();
                    break;
                case 0:
                    System.out.println("Exiting.....");
                    break;
            }
        }while(choice != 0);
    }

    public static void displayChoice(){
        System.out.print("===========================================================================================" +
                "\n[1] Student Management" +
                "\n[2] Course Management" +
                "\n[3] Enroll Student to Section" +
                "\n[4] Assign Instructor to Section" +
                "\n[5] View University Hierarchy" +
                "\n[0] Exit" +
                "\nEnter choice: ");
    }

    public static void studentSwitch(){
        int choice;

        do {
            displayStudentCommands();
            choice = sc.nextInt();
            sc.nextLine();
            System.out.println("===========================================================================================");
            switch (choice){
                case 1:
                    saveStudent();
                    break;
                case 2:
                    registrar.displayAllStudent();
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
            displayCourseCommands();
            choice = sc.nextInt();
            System.out.println("===========================================================================================");
            switch(choice){
                case 1:
                    saveCourse();
                    break;
                case 2:
                    registrar.displayAllCourse();
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
        }while(choice != 7);
    }

    public static void enrollStuToSec(){
            System.out.print("Enter Student ID: ");
            int enrollStuID = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Section ID: ");
            int enrollSecID = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Section Name: ");
            String enrollSecName = sc.nextLine();

            Student stuToEnroll = new Student(enrollStuID);
            Section secToEnroll = new Section(enrollSecID, enrollSecName);

            registrar.enrollStudent(stuToEnroll, secToEnroll);
    }

    public static void assignInstToSec() {
        System.out.println("==================== ASSIGN INSTRUCTOR TO SECTION ====================");
        System.out.print("Enter Instructor ID: ");
        int instID = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Section ID: ");
        int secID = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Section Name: ");
        String secName = sc.nextLine();

        Instructor inst = new Instructor(instID);
        Section sec = new Section(secID, secName);

        registrar.assignInstructorToSection(inst, sec);
        System.out.println("======================================================================");
    }

    public static void viewHierarchy(){
        registrar.showHierarchy(deptReg.getDepartmentList());
    }

    public static void displayStudentCommands(){
        System.out.print("===========================================================================================" +
                "\n[1] Save Student" +
                "\n[2] Display Student" +
                "\n[3] Update Student" +
                "\n[4] Remove Student" +
                "\n[5] Exit" +
                "\nEnter Command: ");
    }

    public static void displayCourseCommands(){
        System.out.print("===========================================================================================" +
                "\n[1] Save Course" +
                "\n[2] Display Course" +
                "\n[3] Update Course" +
                "\n[4] Remove Course" +
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
        registrar.saveStudent(newStudent);
        System.out.println("Student Saved!");
        System.out.println("===========================================================================================");
    }

    public static void updateStudent(){
        System.out.println("===========================================================================================");
        System.out.print("Enter Student ID to update:");
        int updateStudentID = sc.nextInt();

        registrar.updateStudent(new Student(updateStudentID));
        System.out.println("===========================================================================================");
    }

    public static void removeStudent(){
        System.out.println("===========================================================================================");
        System.out.print("Enter Student ID to remove:");
        int removeStudentID = sc.nextInt();

        registrar.removeStudent(new Student(removeStudentID));
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
        registrar.saveCourse(newCourse);
        System.out.println("===========================================================================================");
    }

    public static void updateCourse(){
        System.out.println("===========================================================================================");
        System.out.print("Enter Course ID to update: ");
        int updateCourseID = sc.nextInt();
        sc.nextLine();

        registrar.updateCourse(new Course(updateCourseID));
        System.out.println("===========================================================================================");
    }

    public static void removeCourse(){
        System.out.println("===========================================================================================");
        System.out.print("Enter Course ID to update: ");
        int removeCourseID = sc.nextInt();
        sc.nextLine();

        registrar.updateCourse(new Course(removeCourseID));
        System.out.println("===========================================================================================");
    }
}