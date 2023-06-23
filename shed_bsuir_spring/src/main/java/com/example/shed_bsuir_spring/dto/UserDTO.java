package com.example.shed_bsuir_spring.dto;

import com.example.shed_bsuir_spring.entity.UserEntity;
import com.example.shed_bsuir_spring.service.UserService;

public class UserDTO {
    private String login;
    private String password;
    private String email;
    private int role;
    public UserDTO(int id) throws FailedSetDTO {
        UserService userService = new UserService();
        UserEntity userEntity = userService.getUserByLogin(id);
        if (userEntity == null) throw new FailedSetDTO();

        login = userEntity.getLogin();
        password = userEntity.getPassword();
        email = userEntity.getEmail();
        role = userEntity.getRole();
    }

    public UserDTO(String login, String password, String email, int role) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
