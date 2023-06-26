package com.example.shed_bsuir_spring.service;

import com.example.shed_bsuir_spring.entity.DepartamentEntity;
import com.example.shed_bsuir_spring.entity.FacultyEntity;
import com.example.shed_bsuir_spring.repo.DepartamentRepository;
import com.example.shed_bsuir_spring.repo.FacultyRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DepartamentService {
    @Autowired
    private DepartamentRepository departamentRepository;
    @Autowired
    private FacultyRepository facultyRepository;
    Logger LOGGER = LoggerFactory.getLogger("DEPARTAMENT_SERVICE");

    public FacultyEntity getFacById (int id){
        if (departamentRepository.existsById(id)){
            LOGGER.info("ID = " + id + " exists");
            return departamentRepository.findById(id).getFacultyEntity();
        } else return null;
    }

    public DepartamentEntity getById (int id){
        if (departamentRepository.existsById(id)){
            return departamentRepository.findById(id);
        } else return null;
    }
}
