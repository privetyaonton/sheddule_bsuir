package com.example.shed_bsuir_spring.service;

import com.example.shed_bsuir_spring.entity.FacultyEntity;
import com.example.shed_bsuir_spring.repo.FacultyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;
    Logger LOGGER = LoggerFactory.getLogger("FACULTY_SERVICE");

    public FacultyEntity getById (int id){
        if (facultyRepository.existsById(id)){
            LOGGER.info("EXISTS ID = " + id);
            return facultyRepository.findById(id);
        } return null;
    }

}
