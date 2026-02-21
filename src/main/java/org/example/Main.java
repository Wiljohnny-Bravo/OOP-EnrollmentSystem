package org.example;
import org.example.model.Course;
import org.example.model.Student;

import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("John Doe");
        s.setStudentID("000123");
        s.setProgram("Information Technology");
        System.out.println(s);

        s.setStudentID("000124");
        s.setName("Jane Doe");
        s.setProgram("Information Technology");
        System.out.println(s);

        Course c = new Course();
        c.setCourseID("00001");
        c.setCourseName("Integrative Programming");
        c.setProgram("Information Technology");
        System.out.println(c);
    }
}