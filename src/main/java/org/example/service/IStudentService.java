package org.example.service;

import org.example.model.Student;

public interface IStudentService {
    void addStudent(Student student);
    void displayAllStudent();
    void updateStudent(Student student);
    String removeStudent(Student student);
}
