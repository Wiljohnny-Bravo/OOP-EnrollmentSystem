package org.example.service;

import org.example.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IEnrollmentServiceImplTest {

    private IEnrollmentServiceImpl enrollmentService;

    @BeforeEach
    void setup() {
        enrollmentService = new IEnrollmentServiceImpl();
    }

    @Test
    void shouldEnrollStudentWhenSectionIsNotFull() throws SectionFullException {
        // Arrange
        Student student = new Student(1, "John Doe", "BSIT");
        Section section = new Section(101, "IT2B", 35);

        // Act
        enrollmentService.enrollStudentInSection(student, section);

        // Assert — student should appear in the section's enrolled list
        assertTrue(section.getEnrolledStudents().contains(student));
        // Assert — student's section reference should be updated
        assertEquals(section, student.getSection());
    }

    @Test
    void shouldThrowSectionFullExceptionWhenSectionIsFull() {
        // Arrange — section with capacity of 1, already filled
        Section section = new Section(102, "IT2A", 1);
        Student existing = new Student(2, "Alice", "BSIT");
        section.getEnrolledStudents().add(existing);

        Student newStudent = new Student(3, "Bob", "BSIT");

        // Act & Assert
        SectionFullException ex = assertThrows(
                SectionFullException.class,
                () -> enrollmentService.enrollStudentInSection(newStudent, section)
        );
        assertTrue(ex.getMessage().contains("IT2A"));
    }

    @Test
    void shouldNotAddStudentToSectionWhenFull() {
        // Arrange
        Section section = new Section(103, "IT2D", 1);
        Student existing = new Student(4, "Carol", "BSCS");
        section.getEnrolledStudents().add(existing);

        Student newStudent = new Student(5, "Dave", "BSCS");

        // Act
        try {
            enrollmentService.enrollStudentInSection(newStudent, section);
        } catch (SectionFullException ignored) {}

        // Assert — the new student must NOT have been added
        assertFalse(section.getEnrolledStudents().contains(newStudent));
    }

    @Test
    void shouldEnrollMultipleStudentsUpToCapacity() {
        // Arrange
        Section section = new Section(104, "IT2D", 3);
        Student s1 = new Student(10, "Eve", "BSIT");
        Student s2 = new Student(11, "Frank", "BSIT");
        Student s3 = new Student(12, "Grace", "BSIT");

        // Act & Assert — no exception should be thrown
        assertDoesNotThrow(() -> {
            enrollmentService.enrollStudentInSection(s1, section);
            enrollmentService.enrollStudentInSection(s2, section);
            enrollmentService.enrollStudentInSection(s3, section);
        });
        assertEquals(3, section.getEnrolledStudents().size());
    }

    @Test
    void shouldHandleEmptyDepartmentListGracefully() {
        // Arrange
        List<Department> emptyList = new ArrayList<>();

        // Act & Assert —
        assertDoesNotThrow(() -> enrollmentService.viewDepartmentHierarchy(emptyList));
    }

    @Test
    void shouldDisplayHierarchyWithoutException() {
        // Arrange
        Department dept = new Department(1, "CITE");
        Instructor instructor = new Instructor(1, "Dr. Reyes", "BSIT");
        Section section = new Section(201, "BSIT-1A", 35);
        section.setInstructor(instructor);

        Student student = new Student(1, "Lena", "BSIT");
        section.getEnrolledStudents().add(student);
        dept.addSection(section);

        List<Department> departments = List.of(dept);

        // Act & Assert
        assertDoesNotThrow(() -> enrollmentService.viewDepartmentHierarchy(departments));
    }
}