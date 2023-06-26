package com.example.shed_bsuir_spring.dto;

public class TeacherDTO {
    private String name;
    private String surname;
    private String parentName;
    private String nameDepartament;
    private int id;

    public TeacherDTO() {
    }

    public TeacherDTO(String name, String surname, String parentName, String nameDepartament,
                      int id) {
        this.name = name;
        this.surname = surname;
        this.parentName = parentName;
        this.nameDepartament = nameDepartament;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getNameDepartament() {
        return nameDepartament;
    }

    public void setNameDepartament(String nameDepartament) {
        this.nameDepartament = nameDepartament;
    }
}
