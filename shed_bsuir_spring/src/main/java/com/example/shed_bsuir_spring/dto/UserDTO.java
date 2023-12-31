package com.example.shed_bsuir_spring.dto;

public class UserDTO {
    private String login;
    private String password;
    private String email;
    private int role;
    private int id;

    public UserDTO() {
    }

    public UserDTO(String login, String password, String email, int role, int id){
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
