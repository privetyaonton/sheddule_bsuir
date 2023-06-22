package com.example.shed_bsuir_spring.controller;

import com.example.shed_bsuir_spring.entity.UserEntity;
import com.example.shed_bsuir_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usr")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping ("/find")
    @ResponseBody
    public ResponseEntity<UserEntity> findUserById (@RequestParam int id){
        UserEntity findUser = userService.getUserByLogin(id);
        if (findUser != null){
            return new ResponseEntity<>(findUser, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping ("/add")
    @ResponseBody
    public ResponseEntity<UserEntity> addNewUser (@RequestParam String login,
                                                  @RequestParam String password,
                                                  @RequestParam int role,
                                                  @RequestParam String email){
        UserEntity addUser = new UserEntity(login, password, role, email);
        UserEntity user = userService.insertUser(addUser);
        if (user != null){
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }



}
