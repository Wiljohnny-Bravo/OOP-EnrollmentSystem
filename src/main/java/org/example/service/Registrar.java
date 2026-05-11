package org.example.service;

import org.example.model.Course;
import org.example.model.Department;
import org.example.model.Section;
import org.example.model.Student;

import java.util.List;

public class Registrar {
    private IStudentService studentServ;
    private ICourseService courseServ;
    private IInstructorService instructorServ;
    private DepartmentRegistration departmentServ;
    private IEnrollmentService enrollmentServ;

    public Registrar(IStudentService studentServ, ICourseService courseServ, IInstructorService instructorServ,
                     DepartmentRegistration departmentServ, IEnrollmentService enrollmentServ){
        this.studentServ = studentServ;
        this.courseServ = courseServ;
        this.instructorServ = instructorServ;
        this.departmentServ = departmentServ;
        this.enrollmentServ = enrollmentServ;
    }
    public void enrollStudent(Student student, Section section){
        enrollmentServ.enrollStudentInSection(student, section);
    }

    public void showHierarchy(List<Department> department){
        enrollmentServ.viewDepartmentHierarchy(department);
    }

    public String saveDepartment(Department department){
        departmentServ.saveDepartment(department);
        return "Success";
    }
    public String saveCourse(Course course){
        courseServ.saveCourse(course);
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
        courseServ.removeCourse();
    }

}
