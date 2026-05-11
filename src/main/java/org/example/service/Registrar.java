package org.example.service;

import org.example.model.Course;
import org.example.model.Department;
import org.example.model.Student;

public class Registrar {
    private IStudentService studentReg;
    private ICourseService courseReg;
    private DepartmentRegistration departmentReg;

    public Registrar(IStudentService registration, ICourseService courseReg){
        this.studentReg = registration;
        this.courseReg = courseReg;
    }

    public String saveDepartment(Department department){
        departmentReg.saveDepartment(department);
        return "Success";
    }
    public String saveCourse(Course course){
        courseReg.saveCourse(course);
        return "Success";
    }

    public String saveStudent(Student student){
        studentReg.addStudent(student);
        return "Success";
    }
    public void displayAllStudent(){
        studentReg.displayAllStudent();
    }

    public void displayAllCourse(){
        courseReg.displayAllCourse();
    }

    public void updateStudent(Student student){
        studentReg.updateStudent(student);
    }
    public void updateCourse(Course course){
        courseReg.updateCourse(course);
    }

    public void removeStudent(Student student){
        studentReg.removeStudent(student);
    }
    public void removeCourse(Course course){
        courseReg.removeCourse();
    }

}
