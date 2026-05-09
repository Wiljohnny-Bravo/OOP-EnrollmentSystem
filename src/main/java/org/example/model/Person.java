package org.example.model;

public abstract class Person {
    private int PersonID;
    private String PersonName;

    public Person(){
        this(0);
    }
    public Person(int PersonID){
        this(PersonID, "Unknown");
        this.PersonID = PersonID;
    }
    public Person(int PersonID, String name){
        this.PersonID = PersonID;
        this.PersonName = name;
    }
    public int getID(){
        return PersonID;
    }
    public void setID(int id){
        this.PersonID = id;
    }
    public String getPersonName(){
        return PersonName;
    }
    public void setPersonName(String personName){
        this.PersonName = personName;
    }
    public abstract void mainTask();
}
