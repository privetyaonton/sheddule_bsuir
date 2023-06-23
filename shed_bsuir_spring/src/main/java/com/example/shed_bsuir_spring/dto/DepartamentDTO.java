package com.example.shed_bsuir_spring.dto;

import com.example.shed_bsuir_spring.entity.DepartamentEntity;
import com.example.shed_bsuir_spring.service.DepartamentService;

public class DepartamentDTO {
    private FacultyDTO facultyDTO;
    private String name;

    public DepartamentDTO() {
    }

    public DepartamentDTO(int id) throws FailedSetDTO {
        DepartamentService departamentService = new DepartamentService();
        DepartamentEntity departamentEntity = departamentService.getById(id);
        if (departamentEntity == null) throw new FailedSetDTO();

        facultyDTO = new FacultyDTO(departamentEntity.getIdFaculty());
        name = departamentEntity.getName();
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
