package com.example.shed_bsuir_spring.controller;

import com.example.shed_bsuir_spring.dto.UserDTO;
import com.example.shed_bsuir_spring.entity.UserEntity;
import com.example.shed_bsuir_spring.service.NoContentException;
import com.example.shed_bsuir_spring.service.NotFoundException;
import com.example.shed_bsuir_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping ("/add")
    @ResponseBody
    public ResponseEntity<Void> addNewUser (@RequestParam String login,
                                                  @RequestParam String password,
                                                  @RequestParam int role,
                                                  @RequestParam String email){
        UserEntity addUser = new UserEntity(login, Integer.toString(password.hashCode()),
                role, email);

        try{
            userService.insertUser(addUser);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (NoContentException nce){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping ("/delete")
    @ResponseBody
    public ResponseEntity<Void> deleteUser (@RequestParam int id){
        if (userService.deleteUser(id)){
            return ResponseEntity.ok().build();
        } else return ResponseEntity.notFound().build();
    }

    @GetMapping ("/")
    @ResponseBody
    public ResponseEntity<List<UserDTO>> listAll (){
        return new ResponseEntity<>(userService.list(), HttpStatus.OK);
    }
    @PutMapping ("/upt/pass")
    @ResponseBody
    public ResponseEntity<Void> updatePassword (@RequestParam int id,
                                                @RequestParam String new_pass){
        try{
            userService.updatePassword(id, new_pass);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoContentException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping ("upt/email")
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





}
