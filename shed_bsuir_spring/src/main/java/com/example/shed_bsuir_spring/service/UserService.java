package com.example.shed_bsuir_spring.service;

import com.example.shed_bsuir_spring.entity.UserEntity;
import com.example.shed_bsuir_spring.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public UserEntity getUserByLogin (int id){
        Optional<UserEntity> user = Optional.ofNullable(userRepository.findById(id));
        return user.orElse(null);
    }
    public UserEntity insertUser (UserEntity user){
        if (user.getLogin() != null && user.getPassword() != null &&
        user.getEmail() != null && (user.getRole() == 0 || user.getRole() == 1) &&
        !userRepository.existsByEmail(user.getEmail())){
            return userRepository.save(user);
        } else return null;
    }

}
