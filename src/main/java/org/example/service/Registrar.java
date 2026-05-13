package org.example.service;

import org.example.model.*;
import java.util.List;

public class Registrar {
    private IStudentService studentServ;
    private ICourseService courseServ;
    private IInstructorService instructorServ;
    private DepartmentRegistration departmentServ;
    private IEnrollmentService enrollmentServ;
    private TuitionService tuitionServ;

    public Registrar(IStudentService studentServ, ICourseService courseServ, IInstructorService instructorServ,
                     DepartmentRegistration departmentServ, IEnrollmentService enrollmentServ,
                     TuitionService tuitionServ) {
        this.studentServ = studentServ;
        this.courseServ = courseServ;
        this.instructorServ = instructorServ;
        this.departmentServ = departmentServ;
        this.enrollmentServ = enrollmentServ;
        this.tuitionServ = tuitionServ;
    }

    public void enrollStudent(Student student, Section section) throws SectionFullException {
        enrollmentServ.enrollStudentInSection(student, section);
    }

    public void showHierarchy(List<Department> departments) {
        enrollmentServ.viewDepartmentHierarchy(departments);
    }

    public void assignInstructorToSection(Instructor instructor, Section section) {
        instructorServ.assignToSection(instructor, section);
    }

    public void saveDepartment(Department department) {
        departmentServ.addDepartment(department);
    }

    public String saveStudent(Student student) {
        studentServ.addStudent(student);
        return null;
    }

    public void saveInstructor(Instructor instructor) {
        instructorServ.addInstructor(instructor);
    }

    public void saveCourse(Course course) {
        courseServ.addCourse(course);
    }
}