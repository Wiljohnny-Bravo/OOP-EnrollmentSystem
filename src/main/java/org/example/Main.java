package org.example;

import org.example.model.*;
import org.example.service.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    static IStudentServiceImpl studentReg = new IStudentServiceImpl();
    static ICourseServiceImpl courseReg = new ICourseServiceImpl();
    static IInstructorServiceImpl instructorReg = new IInstructorServiceImpl();
    static DepartmentRegistrationImpl deptReg = new DepartmentRegistrationImpl();
    static IEnrollmentService enrollService = new IEnrollmentServiceImpl();
    static TuitionService tuitionService = new TuitionFeePayment();

    static Registrar registrar = new Registrar(studentReg, courseReg, instructorReg, deptReg, enrollService, tuitionService);
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = -1;
        do {
            try {
                displayMenu();
                System.out.print("Enter choice: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1: saveStudent(); break;
                    case 2: saveInstructor(); break;
                    case 3: saveCourse(); break;
                    case 4: createDepartment(); break;
                    case 5: enrollStudent(); break;
                    case 6: assignInstructor(); break;
                    case 7: registrar.showHierarchy(deptReg.getDepartmentList()); break;
                    case 0: System.out.println("System terminated."); break;
                    default: System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid numeric choice.");
                sc.nextLine(); // Clear the bad input
            }
        } while (choice != 0);
    }

    public static void displayMenu() {
        System.out.println("\n--- UNIVERSITY ENROLLMENT SYSTEM ---");
        System.out.println("1. Add Student");
        System.out.println("2. Add Instructor");
        System.out.println("3. Add Course");
        System.out.println("4. Add Department");
        System.out.println("5. Enroll Student to Section");
        System.out.println("6. Assign Instructor to Section");
        System.out.println("7. View Hierarchy Report");
        System.out.println("0. Exit");
        System.out.println("------------------------------------");
    }

    public static void createDepartment() {
        try {
            System.out.print("Enter Department ID (Numbers only): ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Department Name: ");
            String name = sc.nextLine();
            registrar.saveDepartment(new Department(id, name));
            System.out.println("Status: Department added.");
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid ID format.");
            sc.nextLine();
        }
    }

    public static void enrollStudent() {
        System.out.print("Enter Student ID: ");
        int sID = sc.nextInt();
        sc.nextLine();

        Student foundStudent = findStudent(sID);
        if (foundStudent == null) return;

        System.out.print("Enter Department ID to locate section: ");
        int dID = sc.nextInt();
        sc.nextLine();

        Department dept = findDepartment(dID);
        if (dept == null) return;

        System.out.print("Enter Section Name (e.g. BSIT-1A): ");
        String secName = sc.nextLine();

        Section section = getOrCreateSection(dept, secName);

        try {
            registrar.enrollStudent(foundStudent, section);
        } catch (SectionFullException e) {
            System.out.println("Restriction: " + e.getMessage());
        }
    }

    public static void assignInstructor() {
        System.out.print("Enter Instructor ID: ");
        int insID = sc.nextInt();
        sc.nextLine();

        Instructor foundIns = findInstructor(insID);
        if (foundIns == null) return;

        System.out.print("Enter Department ID: ");
        int dID = sc.nextInt();
        sc.nextLine();

        Department dept = findDepartment(dID);
        if (dept == null) return;

        System.out.print("Enter Section Name: ");
        String secName = sc.nextLine();

        Section section = getOrCreateSection(dept, secName);
        section.setInstructor(foundIns);
        registrar.assignInstructorToSection(foundIns, section);
        System.out.println("Status: Instructor assigned.");
    }

    private static Student findStudent(int id) {
        for (Student s : studentReg.getAllStudents()) if (s.getID() == id) return s;
        System.out.println("Error: Student not found.");
        return null;
    }

    private static Instructor findInstructor(int id) {
        for (Instructor i : instructorReg.getAllInstructors()) if (i.getID() == id) return i;
        System.out.println("Error: Instructor not found.");
        return null;
    }

    private static Department findDepartment(int id) {
        for (Department d : deptReg.getDepartmentList()) if (d.getDepartmentID() == id) return d;
        System.out.println("Error: Department not found.");
        return null;
    }

    private static Section getOrCreateSection(Department dept, String name) {
        for (Section s : dept.getSectionList()) {
            if (s.getSectionName().equalsIgnoreCase(name)) return s;
        }
        Section newSec = new Section((int)(Math.random() * 1000), name);
        dept.addSection(newSec);
        return newSec;
    }

    public static void saveStudent() {
        System.out.print("Student ID: "); int id = sc.nextInt(); sc.nextLine();
        System.out.print("Name: "); String n = sc.nextLine();
        System.out.print("Program: "); String p = sc.nextLine();
        registrar.saveStudent(new Student(id, n, p));
        System.out.println("Status: Student record saved.");
    }

    public static void saveInstructor() {
        System.out.print("Instructor ID: "); int id = sc.nextInt(); sc.nextLine();
        System.out.print("Name: "); String n = sc.nextLine();
        System.out.print("Specialization: "); String s = sc.nextLine();
        registrar.saveInstructor(new Instructor(id, n, s));
        System.out.println("Status: Instructor record saved.");
    }

    public static void saveCourse() {
        System.out.print("Course ID: "); int id = sc.nextInt(); sc.nextLine();
        System.out.print("Name: "); String n = sc.nextLine();
        System.out.print("Program: "); String p = sc.nextLine();
        registrar.saveCourse(new Course(id, n, p));
        System.out.println("Status: Course record saved.");
    }
}