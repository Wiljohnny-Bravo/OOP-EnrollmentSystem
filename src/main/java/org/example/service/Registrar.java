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
                     TuitionService tuitionServ){
        this.studentServ = studentServ;
        this.courseServ = courseServ;
        this.instructorServ = instructorServ;
        this.departmentServ = departmentServ;
        this.enrollmentServ = enrollmentServ;
        this.tuitionServ = tuitionServ;
    }
    public void enrollStudent(Student student, Section section){
        enrollmentServ.enrollStudentInSection(student, section);
    }

    public void showHierarchy(List<Department> department){
        enrollmentServ.viewDepartmentHierarchy(department);
    }

    public void assignInstructorToSection(Instructor instructor, Section section) {
        instructorServ.assignToSection(instructor, section);
    }

    public String saveDepartment(Department department){
        departmentServ.addDepartment(department);
        return "Success";
    }

    public void saveInstructor(Instructor instructor) {
        instructorServ.addInstructor(instructor);
    }

    public void displayAllInstructors() {
        List<Instructor> instructors = instructorServ.getAllInstructors();
        if (instructors.isEmpty()) {
            System.out.println("No instructors found.");
        } else {
            instructors.forEach(System.out::println);
        }
    }

    public void updateInstructor(Instructor instructor) {
        instructorServ.updateInstructor(instructor);
    }

    public String removeInstructor(Instructor instructor) {
        instructorServ.removeInstructor(instructor);
        return null;
    }

    public String saveCourse(Course course){
        courseServ.addCourse(course);
        return "Success";
    }

    public String saveStudent(Student student){
        studentServ.addStudent(student);
        return "Success";
    }
    public void displayAllStudent(){
        studentServ.displayAllStudent();
    }

    public void displayAllCourse(){
        courseServ.displayAllCourse();
    }

    public void updateStudent(Student student){
        studentServ.updateStudent(student);
    }
    public void updateCourse(Course course){
        courseServ.updateCourse(course);
    }

    public void removeStudent(Student student){
        studentServ.removeStudent(student);
    }
    public void removeCourse(Course course){
        courseServ.removeCourse(course);
    }

}
