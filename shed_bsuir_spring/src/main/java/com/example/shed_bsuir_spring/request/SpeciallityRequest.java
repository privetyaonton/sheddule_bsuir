package com.example.shed_bsuir_spring.request;

public class SpeciallityRequest {
    private int facultyID;
    private String name;

    public SpeciallityRequest(int facultyID, String name) {
        this.facultyID = facultyID;
        this.name = name;
    }

    public int getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(int facultyID) {
        this.facultyID = facultyID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
