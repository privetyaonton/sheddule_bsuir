package com.example.shed_bsuir_spring.dto;

import com.example.shed_bsuir_spring.entity.FacultyEntity;
import com.example.shed_bsuir_spring.service.FacultyService;

public class FacultyDTO {
    private String fullName;
    private String shortName;

    public FacultyDTO(int id) throws FailedSetDTO {
        FacultyService facultyService = new FacultyService();
        FacultyEntity facultyEntity = facultyService.getById(id);
        if (facultyEntity == null) throw new FailedSetDTO();

        fullName = facultyEntity.getFull_name();
        shortName = facultyEntity.getShort_name();
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
