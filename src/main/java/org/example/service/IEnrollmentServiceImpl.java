package org.example.service;

import org.example.model.Department;
import org.example.model.Instructor;
import org.example.model.Section;
import org.example.model.Student;

import java.util.List;

public class IEnrollmentServiceImpl implements IEnrollmentService {

    public void enrollStudentInSection(Student student, Section section) {
        student.setSection(section);
        System.out.println("Student " + student.getPersonName() +
                " successfully enrolled in " + section.getSectionName());
    }

    @Override
    public void viewDepartmentHierarchy(List<Department> departments) {
        System.out.println("\n========== UNIVERSITY HIERARCHY ==========");
        for (Department dept : departments) {
            System.out.println("Department: " + dept.getDepartmentName());

            // Note: Ensure Department.java provides access to the actual List<Instructor>
            for (Instructor ins : dept.getInstructorList()) {
                System.out.print("  └── Instructor: " + ins.getPersonName());

                // Show the section the instructor is handling
                if (ins.getSection() != null) {
                    System.out.println(" (Handling Section: " + ins.getSection().getSectionName() + ")");
                } else {
                    System.out.println(" (No Section Assigned)");
                }
            }
        }
        System.out.println("==========================================\n");
    }
}