package com.example.shed_bsuir_spring.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_user")
    private int id;

    @Column (name = "login")
    private String login;

    @Column (name = "password")
    private String password;

    @Column (name = "role")
    private int role;

    @Column (name = "email")
    private String email;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable (name = "teacherlist", joinColumns = @JoinColumn(name = "id_user"),
    inverseJoinColumns = @JoinColumn(name = "id_teacher"))
    private Set <TeacherEntity> teacherEntitySet;

    public Set<TeacherEntity> getTeacherEntitySet() {
        return teacherEntitySet;
    }

    public void setTeacherEntitySet(Set<TeacherEntity> teacherEntitySet) {
        this.teacherEntitySet = teacherEntitySet;
    }

    public UserEntity(){
    }

    public UserEntity (String login, String password, int role, String email){
        setLogin(login);
        setPassword(password);
        setRole(role);
        setEmail(email);
    }


    public int getId (){
        return id;
    }

    public String getLogin(){
        return login;
    }

    public String getPassword(){
        return password;
    }

    public int getRole(){
        return role;
    }

    public String getEmail(){
        return email;
    }
    public void setId (int id){
        this.id = id;
    }
    public void setLogin (String s){
        this.login = s;
    }
    public void setPassword (String s){
        this.password = s;
    }
    public void setRole (int role){
        this.role = role;
    }
    public void setEmail (String s){
        this.email = s;
    }
}
