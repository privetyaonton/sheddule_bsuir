package com.example.shed_bsuir_spring.service;

import com.example.shed_bsuir_spring.dto.UserDTO;
import com.example.shed_bsuir_spring.entity.UserEntity;
import com.example.shed_bsuir_spring.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public UserEntity getUserByLogin (int id){
        Optional<UserEntity> user = Optional.ofNullable(userRepository.findById(id));
        return user.orElse(null);
    }
    public void insertUser (UserEntity user) throws NoContentException {
        if (user.getLogin() != null && user.getPassword() != null &&
        user.getEmail() != null && (user.getRole() == 0 || user.getRole() == 1) &&
        !userRepository.existsByEmail(user.getEmail())){
            userRepository.save(user);
        } else throw new NoContentException();
    }
    public boolean deleteUser (int id){
        if (userRepository.existsById(id)){
            userRepository.deleteById((long) id);
            return true;
        } else  return false;
    }
    public List<UserDTO> list (){
        List<UserDTO> userDTOList = new ArrayList<>();
        List<UserEntity> userEntityList = userRepository.findAll();
        for (ListIterator<UserEntity> iterator = userEntityList.listIterator();
             iterator.hasNext(); ){
            UserEntity userEntity = iterator.next();
            userDTOList.add(new UserDTO(userEntity.getLogin(), userEntity.getPassword(),
                    userEntity.getEmail(), userEntity.getRole()));
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

        UserEntity userEntity = getUserByLogin(id_user);
    }


}
