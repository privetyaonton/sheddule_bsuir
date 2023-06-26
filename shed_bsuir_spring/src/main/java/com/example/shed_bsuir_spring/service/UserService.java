package com.example.shed_bsuir_spring.service;

import com.example.shed_bsuir_spring.dto.*;
import com.example.shed_bsuir_spring.entity.TeacherEntity;
import com.example.shed_bsuir_spring.entity.UserEntity;
import com.example.shed_bsuir_spring.repo.TeacherRepository;
import com.example.shed_bsuir_spring.repo.UserRepository;
import com.example.shed_bsuir_spring.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    public UserDTO getUserByLogin (int id) throws NotFoundException{
        if (userRepository.existsById(id)){
            UserEntity userEntity = userRepository.findById(id);
            return new UserDTO(userEntity.getLogin(), userEntity.getPassword(),
                        userEntity.getEmail(), userEntity.getRole(), id);
        } else throw new NotFoundException();
    }
    public void insertUser (UserRequest userRequest) throws NoContentException {
        if (userRequest.getLogin() != null && userRequest.getPassword() != null &&
        userRequest.getEmail() != null && (userRequest.getRole() == 0 ||
                userRequest.getRole() == 1) && !userRepository.existsByEmail(
                        userRequest.getEmail()) && !userRepository.existsByLogin(
                                userRequest.getLogin())){
            userRepository.save(new UserEntity(userRequest.getLogin(),
                    userRequest.getPassword(), userRequest.getRole(),
                    userRequest.getEmail()));
        } else throw new NoContentException();
    }
    public void deleteUser (Long id) throws NotFoundException{
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
        } else throw new NotFoundException();
    }
    public List<UserDTO> list (){
        List<UserDTO> userDTOList = new ArrayList<>();
        List<UserEntity> userEntityList = userRepository.findAll();
        for (UserEntity userEntity : userEntityList){
            userDTOList.add(new UserDTO(userEntity.getLogin(), userEntity.getPassword(),
                    userEntity.getEmail(), userEntity.getRole(), userEntity.getId()));
        }
        return userDTOList;
    }
    public void updatePassword (int id, String s) throws NotFoundException,
            NoContentException{
        if (userRepository.existsById(id)) {
            UserEntity userEntity = userRepository.findById(id);
            if (s != null) {
                userEntity.setPassword(Integer.toString(s.hashCode()));
                userRepository.save(userEntity);
            } else throw new NoContentException();
        } else throw new NotFoundException();
    }
    public void updateEmail (int id, String s) throws NotFoundException,
            NoContentException{
        if (userRepository.existsById(id)) {
            UserEntity userEntity = userRepository.findById(id);
            if (s != null) {
                userEntity.setEmail(s);
                userRepository.save(userEntity);
            } else throw new NoContentException();
        } else throw new NotFoundException();
    }
    public void addTeacherToSet (int id_user, int id_teacher) throws NotFoundException{
        if (userRepository.existsById(id_user) && teacherRepository.existsById(id_teacher)){
            UserEntity userEntity = userRepository.findById(id_user);
            TeacherEntity teacherEntity = teacherRepository.findById(id_teacher);
            userEntity.getTeacherEntitySet().add(teacherEntity);
            userRepository.save(userEntity);
        } else throw new NotFoundException();
    }
    public List<TeacherDTO> getTeacherById (int id) throws NotFoundException{
        if (userRepository.existsById(id)){
            UserEntity userEntity = userRepository.findById(id);
            Set<TeacherEntity> teacherEntitySet = userEntity.getTeacherEntitySet();
            List<TeacherDTO> teacherDTOList = new ArrayList<>();
            for (TeacherEntity teacherEntity : teacherEntitySet){
                teacherDTOList.add(new TeacherDTO(teacherEntity.getName(),
                        teacherEntity.getSurname(), teacherEntity.getParentName(),
                        teacherEntity.getDepartamentEntity().getName(), teacherEntity.getId()));
            }
            return teacherDTOList;
        } else throw new NotFoundException();
    }



}
