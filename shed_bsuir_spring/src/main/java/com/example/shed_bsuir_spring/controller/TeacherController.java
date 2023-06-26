package com.example.shed_bsuir_spring.controller;

import com.example.shed_bsuir_spring.dto.TeacherDTO;
import com.example.shed_bsuir_spring.entity.TeacherEntity;
import com.example.shed_bsuir_spring.request.TeacherRequest;
import com.example.shed_bsuir_spring.service.NoContentException;
import com.example.shed_bsuir_spring.service.NotFoundException;
import com.example.shed_bsuir_spring.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @DeleteMapping ("/{id}/delete")
    @ResponseBody
    public ResponseEntity<Void> deleteById (@PathVariable int id){
        try{
            teacherService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFoundException notFoundException){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping ("/add")
    @ResponseBody
    public ResponseEntity<Void> add (@RequestBody TeacherRequest teacherRequest){
        try{
            teacherService.add(teacherRequest);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (NoContentException noContentException){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping ("/")
    @ResponseBody
    public ResponseEntity<List<TeacherDTO>> list (){
        return new ResponseEntity<>(teacherService.listAll(), HttpStatus.OK);
    }
}
