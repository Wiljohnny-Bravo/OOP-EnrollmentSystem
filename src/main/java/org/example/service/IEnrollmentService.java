package org.example.service;

import org.example.model.Department;
import org.example.model.Section;
import org.example.model.Student;
import java.util.List;

public interface IEnrollmentService {
    void enrollStudentInSection(Student student, Section section) throws SectionFullException;
    void viewDepartmentHierarchy(List<Department> departments);
}