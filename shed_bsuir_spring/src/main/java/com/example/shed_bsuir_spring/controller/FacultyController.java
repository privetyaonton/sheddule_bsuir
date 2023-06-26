package com.example.shed_bsuir_spring.controller;

import com.example.shed_bsuir_spring.dto.FacultyDTO;
import com.example.shed_bsuir_spring.request.FacultyRequest;
import com.example.shed_bsuir_spring.service.FacultyService;
import com.example.shed_bsuir_spring.service.NoContentException;
import com.example.shed_bsuir_spring.service.NotFoundException;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/fac")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @GetMapping ("/{id}")
    @ResponseBody
    public ResponseEntity<FacultyDTO> getById (@PathVariable int id){
        try{
            return new ResponseEntity<>(facultyService.getById(id), HttpStatus.FOUND);
        } catch (NotFoundException notFoundException){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping ("/")
    @ResponseBody
    public ResponseEntity<List<FacultyDTO>> getAll (){
        return new ResponseEntity<>(facultyService.listAll(), HttpStatus.OK);
    }
    @PostMapping ("/add")
    @ResponseBody
    public ResponseEntity<Void> add (@RequestBody FacultyRequest facultyRequest){
        try{
          facultyService.add(facultyRequest);
          return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (NoContentException noContentException){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @DeleteMapping ("/{id}/delete")
    @ResponseBody
    public ResponseEntity<Void> delete (@PathVariable Long id){
        try{
            facultyService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFoundException notFoundException){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping ("/{id}/upt")
    @ResponseBody
    public ResponseEntity<Void> update (@PathVariable int id,
                                        @RequestBody FacultyRequest facultyRequest){
        try{
            facultyService.update(facultyRequest, id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFoundException notFoundException){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (NoContentException contentException){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
