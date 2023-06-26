package com.example.shed_bsuir_spring.request;

public class TeacherRequest {
    private String surname;
    private String name;
    private String parentName;
    private int departamentID;

    public TeacherRequest(String surname, String name, String parentName, int departamentID) {
        this.surname = surname;
        this.name = name;
        this.parentName = parentName;
        this.departamentID = departamentID;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public int getDepartamentID() {
        return departamentID;
    }

    public void setDepartamentID(int departamentID) {
        this.departamentID = departamentID;
    }
}
