package com.example.shed_bsuir_spring.dto;

import com.example.shed_bsuir_spring.entity.DepartamentEntity;
import com.example.shed_bsuir_spring.service.DepartamentService;

public class DepartamentDTO {
    private FacultyDTO facultyDTO;
    private String name;

    public DepartamentDTO() {
    }

    public DepartamentDTO(FacultyDTO facultyDTO, String name) throws FailedSetDTO{
        this.facultyDTO = facultyDTO;
        if (name == null) throw new FailedSetDTO();
        this.name = name;
    }
    public FacultyDTO getFacultyDTO() {
        return facultyDTO;
    }

    public void setFacultyDTO(FacultyDTO facultyDTO) {
        this.facultyDTO = facultyDTO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
