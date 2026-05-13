package org.example.service;

import org.example.model.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ICourseServiceImplTest {

    private ICourseServiceImpl courseService;

    @BeforeEach
    void setup() {
        courseService = new ICourseServiceImpl();
    }

    @Test
    void shouldAddCourseToList() {
        // Arrange
        Course course = new Course(1, "Data Structures", "BSIT");

        // Act
        courseService.addCourse(course);

        // Assert
        List<Course> all = courseService.getAllCourses();
        assertEquals(1, all.size());
        assertTrue(all.contains(course));
    }

    @Test
    void shouldAddMultipleCourses() {
        // Arrange
        Course c1 = new Course(1, "Data Structures", "BSIT");
        Course c2 = new Course(2, "Algorithms", "BSCS");
        Course c3 = new Course(3, "Operating Systems", "BSECE");

        // Act
        courseService.addCourse(c1);
        courseService.addCourse(c2);
        courseService.addCourse(c3);

        // Assert
        assertEquals(3, courseService.getAllCourses().size());
    }

    @Test
    void shouldReturnEmptyListInitially() {
        assertTrue(courseService.getAllCourses().isEmpty());
    }

    @Test
    void shouldRemoveExistingCourse() {
        // Arrange
        Course course = new Course(1, "Data Structures", "BSIT");
        courseService.addCourse(course);

        // Act
        String result = courseService.removeCourse(course);

        // Assert
        assertEquals("Deleted Successfully", result);
        assertFalse(courseService.getAllCourses().contains(course));
    }

    @Test
    void shouldReturnErrorWhenRemovingNonExistentCourse() {
        // Arrange
        Course ghost = new Course(999, "Ghost Course", "N/A");

        // Act
        String result = courseService.removeCourse(ghost);

        // Assert
        assertEquals("Error Found.", result);
    }

    @Test
    void shouldReduceListSizeAfterRemoval() {
        // Arrange
        Course c1 = new Course(1, "Data Structures", "BSIT");
        Course c2 = new Course(2, "Algorithms", "BSCS");
        courseService.addCourse(c1);
        courseService.addCourse(c2);

        // Act
        courseService.removeCourse(c1);

        // Assert
        assertEquals(1, courseService.getAllCourses().size());
        assertFalse(courseService.getAllCourses().contains(c1));
    }

    @Test
    void shouldBeEmptyAfterAllCoursesRemoved() {
        // Arrange
        Course course = new Course(1, "Data Structures", "BSIT");
        courseService.addCourse(course);

        // Act
        courseService.removeCourse(course);

        // Assert
        assertTrue(courseService.getAllCourses().isEmpty());
    }

    @Test
    void shouldRetrieveSameCourseObjectThatWasAdded() {
        // Arrange
        Course course = new Course(5, "Software Engineering", "BSIT");
        courseService.addCourse(course);

        // Act
        Course retrieved = courseService.getAllCourses().get(0);

        // Assert
        assertEquals(5, retrieved.getCourseID());
        assertEquals("Software Engineering", retrieved.getCourseName());
        assertEquals("BSIT", retrieved.getCourseProgram());
    }
}