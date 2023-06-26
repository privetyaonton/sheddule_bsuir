package com.example.shed_bsuir_spring.dto;

public class SpeciallityDTO {
    private int id;
    private String name;
    private String nameFaculty;

    public SpeciallityDTO(int id, String name, String nameFaculty) {
        this.id = id;
        this.name = name;
        this.nameFaculty = nameFaculty;
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

    public String getNameFaculty() {
        return nameFaculty;
    }

    public void setNameFaculty(String nameFaculty) {
        this.nameFaculty = nameFaculty;
    }
}
