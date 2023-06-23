package com.example.shed_bsuir_spring.controller;

import com.example.shed_bsuir_spring.dto.DepartamentDTO;
import com.example.shed_bsuir_spring.dto.FailedSetDTO;
import com.example.shed_bsuir_spring.entity.DepartamentEntity;
import com.example.shed_bsuir_spring.entity.FacultyEntity;
import com.example.shed_bsuir_spring.service.DepartamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping ("/api/dep")
public class DepartamentController {
    @Autowired
    private DepartamentService departamentService;

    @GetMapping ("/fac")
    public ResponseEntity<FacultyEntity> getFac (@RequestParam int id){
        FacultyEntity facultyEntity = departamentService.getFacById(id);
        if (facultyEntity != null){
            return new ResponseEntity<>(facultyEntity, HttpStatus.FOUND);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping ("/add")
    public ResponseEntity<DepartamentDTO> addNew (@RequestParam String name,
                                                  @RequestParam int idf){
        DepartamentEntity departamentEntity = new DepartamentEntity(name, idf);
        DepartamentEntity departamentEntityAdd = departamentService.addNew(
                departamentEntity);
        if (departamentEntityAdd != null){
            try {
                return new ResponseEntity<>(new DepartamentDTO(departamentEntityAdd.getId()),
                        HttpStatus.CREATED);
            } catch (FailedSetDTO f){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
