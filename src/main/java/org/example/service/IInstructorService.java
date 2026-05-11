package org.example.service;

import org.example.model.Instructor;
import org.example.model.Section;

import java.util.List;

public interface IInstructorService {
    void addInstructor(Instructor instructor);
    void updateInstructor(Instructor instructor);
    String removeInstructor(Instructor instructor);
    void assignToSection(Instructor instructor, Section section);
    void getInstructorDetails(Instructor instructor);
    List<Instructor> getAllInstructors();

}
