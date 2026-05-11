package org.example.service;

import org.example.model.Course;

public interface ICourseService {
    void saveCourse(Course course);
    void displayAllCourse();
    void updateCourse(Course course);
    String removeCourse();
}
