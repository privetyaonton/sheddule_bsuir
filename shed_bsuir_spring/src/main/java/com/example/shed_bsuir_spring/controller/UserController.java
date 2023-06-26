package com.example.shed_bsuir_spring.controller;

import com.example.shed_bsuir_spring.dto.TeacherDTO;
import com.example.shed_bsuir_spring.dto.UserDTO;
import com.example.shed_bsuir_spring.entity.UserEntity;
import com.example.shed_bsuir_spring.request.UserRequest;
import com.example.shed_bsuir_spring.service.NoContentException;
import com.example.shed_bsuir_spring.service.NotFoundException;
import com.example.shed_bsuir_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/usr")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping ("/{id}")
    @ResponseBody
    public ResponseEntity<UserDTO> findUserById (@PathVariable int id){
        try{
            UserDTO userDTO = userService.getUserByLogin(id);
            return new ResponseEntity<>(userDTO, HttpStatus.FOUND);
        } catch (NotFoundException nf){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping ("/add")
    @ResponseBody
    public ResponseEntity<Void> addNewUser (@RequestBody UserRequest userRequest){
        try{
            userService.insertUser(userRequest);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (NoContentException nce){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping ("/delete")
    @ResponseBody
    public ResponseEntity<Void> deleteUser (@RequestParam Long id){
        try{
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFoundException notFoundException){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping ("/")
    @ResponseBody
    public ResponseEntity<List<UserDTO>> listAll (){
        return new ResponseEntity<>(userService.list(), HttpStatus.OK);
    }
    @PutMapping ("/upt/pass")
    @ResponseBody
    public ResponseEntity<Void> updatePassword (@RequestParam int id,
                                                @RequestParam String newPass){
        try{
            userService.updatePassword(id, newPass);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoContentException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping ("/upt/email")
    @ResponseBody
    public ResponseEntity<Void> updateEmail (@RequestParam int id,
                                                @RequestParam String new_email){
        try{
            userService.updateEmail(id, new_email);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoContentException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping ("/{id}/teacher/add")
    @ResponseBody
    public ResponseEntity<Void> addTeacherToUser (@PathVariable int id,
                                                  @RequestParam int idt){
        try{
            userService.addTeacherToSet(id, idt);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFoundException notFoundException){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{id}/teacher/")
    @ResponseBody
    public ResponseEntity<List<TeacherDTO>> getTeacherOfUser (@PathVariable int id){
        try{
            return new ResponseEntity<>(userService.getTeacherById(id), HttpStatus.OK);
        } catch (NotFoundException notFoundException){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }







}
