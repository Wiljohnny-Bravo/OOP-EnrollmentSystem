package org.example.service;

import org.example.model.*;
import java.util.List;

public class IEnrollmentServiceImpl implements IEnrollmentService {

    @Override
    public void enrollStudentInSection(Student student, Section section) throws SectionFullException {
        // Validation: Check if the section has reached its limit
        if (section.isFull()) {
            throw new SectionFullException("Enrollment failed: Section " + section.getSectionName() + " is full.");
        }

        // Maintain the relationship: add student to section's internal list
        section.getEnrolledStudents().add(student);
        // Link the section to the student
        student.setSection(section);

        System.out.println("Status: Student " + student.getPersonName() + " successfully enrolled in " + section.getSectionName());
    }

    @Override
    public void viewDepartmentHierarchy(List<Department> departments) {
        if (departments.isEmpty()) {
            System.out.println("Notice: No departments found in the system.");
            return;
        }

        System.out.println("\n----------------- UNIVERSITY HIERARCHY -----------------");
        for (Department dept : departments) {
            System.out.println("Department: " + dept.getDepartmentName() + " (ID: " + dept.getDepartmentID() + ")");

            if (dept.getSectionList().isEmpty()) {
                System.out.println("   [No sections registered]");
            }

            for (Section sec : dept.getSectionList()) {
                System.out.println("   Section: " + sec.getSectionName() + " (Capacity: " + sec.getEnrolledStudents().size() + "/35)");

                Instructor ins = sec.getInstructor();
                System.out.println("      Instructor: " + (ins != null ? ins.getPersonName() : "To be assigned"));

                System.out.println("      Enrolled Students:");
                if (sec.getEnrolledStudents().isEmpty()) {
                    System.out.println("         - None");
                } else {
                    for (Student s : sec.getEnrolledStudents()) {
                        System.out.println("         - [ID: " + s.getID() + "] " + s.getPersonName());
                    }
                }
            }
        }
        System.out.println("--------------------------------------------------------\n");
    }
}