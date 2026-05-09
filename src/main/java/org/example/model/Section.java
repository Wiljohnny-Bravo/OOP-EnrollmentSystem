package org.example.model;

public class Section {
    private int sectionID;
    private String sectionName;

    public Section(){
        this(0);
    }
    public Section(int sectionID){
        this(sectionID, "Unknown");
        this.sectionID = sectionID;
    }
    public Section(int sectionID, String sectionName){
        this.sectionID = sectionID;
        this.sectionName = sectionName;
    }
    public int getSectionID(){
        return sectionID;
    }

    public void setSectionID(int sectionID) {
        this.sectionID = sectionID;
    }
    public String getSectionName(){
        return sectionName;
    }
    public void setSectionName(String sectionName){
        this.sectionName = sectionName;
    }

    @Override
    public String toString() {
        return "SECTION: \n" +
                "sectionID: " + sectionID + "\n" +
                ", sectionName='" + sectionName + '\n';
    }
}
