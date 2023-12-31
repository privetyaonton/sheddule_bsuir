package com.example.shed_bsuir_spring.dto;

import com.example.shed_bsuir_spring.entity.FacultyEntity;
import com.example.shed_bsuir_spring.service.FacultyService;

public class FacultyDTO {
    private String fullName;
    private String shortName;
    private int id;

    public FacultyDTO(String fullName, String shortName, int id){
        this.fullName = fullName;
        this.shortName = shortName;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
