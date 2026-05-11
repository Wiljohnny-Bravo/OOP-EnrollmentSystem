package org.example.model;

public class Instructor extends Person{
//    private ArrayList<Course> course = new ArrayList<>();
    private String course;
    private String section;

    public Instructor(){
        this(0);
    }
    public Instructor(int id){
        this(id, "Unknown");
    }
    public Instructor(int id, String name){
        this(id, name, "Unknown");
    }
    public Instructor(int id, String name, String course){
        super(id, name);
        this.course = course;
    }

    public void setSection(String section){
        this.section = section;
    }

    public Section getSection(){
        return section;
    }

    @Override
    public void mainTask() {
        System.out.println("Main Task: Teach");
    }
    public String toString() {
        return "INSTRUCTOR:" +
                "Instructor ID: " + super.getID() + " || " +
                "Instructor Name: " + super.getPersonName() + " || " +
                "Course: " + course + "\n ";
    }

}