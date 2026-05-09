package org.example.service;

import org.example.model.Instructor;
import org.example.model.Section;

public interface InstructorRegistration {
    void addInstructor(Instructor instructor);
    void assignToSection(Instructor instructor, Section section);
    void getInstructorDetails(Instructor instructor);
}
