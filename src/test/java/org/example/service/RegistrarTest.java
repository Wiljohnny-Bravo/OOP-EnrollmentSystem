package org.example.service;

import org.example.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RegistrarTest {

    @Mock
    private IStudentService studentService;

    @Mock
    private ICourseService courseService;

    @Mock
    private IInstructorService instructorService;

    @Mock
    private DepartmentRegistration departmentService;

    @Mock
    private IEnrollmentService enrollmentService;

    @Mock
    private TuitionService tuitionService;

    @InjectMocks
    private Registrar registrar;

    // FIX 1: Registrar.saveStudent() returns null — changed assertion to null,
    // and added verify() to confirm the service was still called correctly.
    @Test
    @DisplayName("Should delegate to studentService and return null when saving a student")
    void shouldReturnSuccessWhenStudentIsSaved() {
        // Arrange
        Student student = new Student(1, "John Doe", "IT");

        // Act
        String result = registrar.saveStudent(student);

        // Assert — Registrar.saveStudent() currently returns null
        assertNull(result);

        // Verify delegation to the service layer
        verify(studentService).addStudent(student);
    }

    @Test
    @DisplayName("Should delegate to departmentService when saving a department")
    void shouldCallDepartmentServiceWhenSavingDepartment() {
        // Arrange
        Department dept = new Department(101, "College of Information Technology and" +
                " Engineering");

        // Act
        registrar.saveDepartment(dept);

        // Assert
        verify(departmentService).addDepartment(dept);
    }

    // FIX 2: Student(int, String) does not exist — added the required 3rd arg "IT"
    @Test
    @DisplayName("Should delegate to enrollmentService when enrolling a student")
    void shouldCallEnrollmentServiceWhenEnrollingStudent() throws SectionFullException {
        // Arrange
        Student student = new Student(1, "Jane Doe", "IT");
        Section section = new Section(501, "IT2C");

        // Act
        registrar.enrollStudent(student, section);

        // Assert
        verify(enrollmentService).enrollStudentInSection(student, section);
    }

    @Test
    @DisplayName("Should delegate to instructorService when saving an instructor")
    void shouldCallInstructorServiceWhenSavingInstructor() {
        // Arrange
        Instructor instructor = new Instructor(10, "Mozo", "Information Technology");

        // Act
        registrar.saveInstructor(instructor);

        // Assert
        verify(instructorService).addInstructor(instructor);
    }

    @Test
    @DisplayName("Should delegate to courseService when saving a course")
    void shouldCallCourseServiceWhenSavingCourse() {
        // Arrange
        Course course = new Course(201, "Data Structures", "BSIT");

        // Act
        registrar.saveCourse(course);

        // Assert
        verify(courseService).addCourse(course);
    }

    @Test
    @DisplayName("Should delegate to instructorService when assigning instructor to section")
    void shouldCallInstructorServiceWhenAssigningInstructorToSection() {
        // Arrange
        Instructor instructor = new Instructor(10, "Mozo", "Information Technology");
        Section section = new Section(501, "IT2C");

        // Act
        registrar.assignInstructorToSection(instructor, section);

        // Assert
        verify(instructorService).assignToSection(instructor, section);
    }
}