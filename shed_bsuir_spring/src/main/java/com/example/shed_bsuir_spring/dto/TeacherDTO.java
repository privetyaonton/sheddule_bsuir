package com.example.shed_bsuir_spring.dto;


import com.example.shed_bsuir_spring.entity.TeacherEntity;
import com.example.shed_bsuir_spring.repo.TeacherRepository;
import com.example.shed_bsuir_spring.service.NotFoundException;
import com.example.shed_bsuir_spring.service.TeacherService;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class TeacherDTO {
    private String name;
    private String surname;
    private String parentName;
    private DepartamentDTO departamentDTO;

    public TeacherDTO (int id){
    }
}
