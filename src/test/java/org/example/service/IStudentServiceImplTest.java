package org.example.service;

import org.example.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IStudentServiceImplTest {

    private IStudentServiceImpl studentService;

    @BeforeEach
    void setup() {
        studentService = new IStudentServiceImpl();
    }

    @Test
    void shouldAddStudentToList() {
        // Arrange
        Student student = new Student(1, "Juan dela Cruz", "BSIT");

        // Act
        studentService.addStudent(student);

        // Assert
        List<Student> all = studentService.getAllStudents();
        assertEquals(1, all.size());
        assertTrue(all.contains(student));
    }

    @Test
    void shouldAddMultipleStudents() {
        // Arrange
        Student s1 = new Student(1, "Ana", "BSIT");
        Student s2 = new Student(2, "Ben", "BSCS");
        Student s3 = new Student(3, "Cara", "BSECE");

        // Act
        studentService.addStudent(s1);
        studentService.addStudent(s2);
        studentService.addStudent(s3);

        // Assert
        assertEquals(3, studentService.getAllStudents().size());
    }

    @Test
    void shouldRemoveExistingStudent() {
        // Arrange
        Student student = new Student(1, "Juan", "BSIT");
        studentService.addStudent(student);

        // Act
        String result = studentService.removeStudent(student);

        // Assert
        assertEquals("Deleted Successfully", result);
        assertFalse(studentService.getAllStudents().contains(student));
    }

    @Test
    void shouldReturnErrorWhenRemovingNonExistentStudent() {
        // Arrange
        Student ghost = new Student(999, "Ghost", "BSIT");

        // Act
        String result = studentService.removeStudent(ghost);

        // Assert
        assertEquals("Error Found.", result);
    }

    @Test
    void shouldReduceListSizeAfterRemoval() {
        // Arrange
        Student s1 = new Student(1, "Ana", "BSIT");
        Student s2 = new Student(2, "Ben", "BSCS");
        studentService.addStudent(s1);
        studentService.addStudent(s2);

        // Act
        studentService.removeStudent(s1);

        // Assert
        assertEquals(1, studentService.getAllStudents().size());
    }

    @Test
    void shouldReturnStudentByValidId() {
        // Arrange
        Student student = new Student(42, "Maria", "BSIT");
        studentService.addStudent(student);

        // Act
        Student found = studentService.getStudentById(42);

        // Assert
        assertNotNull(found);
        assertEquals("Maria", found.getPersonName());
    }

    @Test
    void shouldReturnNullForNonExistentId() {
        // Act
        Student found = studentService.getStudentById(999);

        // Assert
        assertNull(found);
    }

    @Test
    void shouldReturnEmptyListInitially() {
        // Act & Assert
        assertTrue(studentService.getAllStudents().isEmpty());
    }
}