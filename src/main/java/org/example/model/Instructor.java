package org.example.model;

public class Instructor extends Person{
//    private ArrayList<Course> course = new ArrayList<>();
    private String course;
    private Section section;

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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setSection(Section section){
        this.section = section;
    }

    public Section getSection(){
        return section;
    }

    @Override
    public void mainTask() {
        System.out.println("Main Task: Teach");
    }

    @Override
    public String toString() {
        String sectionInfo = (section != null) ? section.getSectionName() : "None";
        return String.format("Instructor [ID: %d | Name: %-20s | Course: %-15s | Section: %s]",
                getID(), getPersonName(), course, sectionInfo);
    }

}