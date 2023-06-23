package com.example.shed_bsuir_spring.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table (name = "teacher")
public class TeacherEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_teacher")
    private int id;

    @Column (name = "name")
    private String name;

    @Column (name = "surname")
    private String surname;

    @Column (name = "parent_name")
    private String parentName;

    @Column (name = "id_departament")
    private int idDepartament;

    @ManyToOne
    @JoinColumn (name = "id_departament", referencedColumnName = "id_departament")
    private DepartamentEntity departamentEntity;

    @ManyToMany (mappedBy = "teacherEntitySet")
    private Set<UserEntity> teacherset;

    public Set<UserEntity> getTeacherset() {
        return teacherset;
    }

    public void setTeacherset(Set<UserEntity> teacherlist) {
        this.teacherset = teacherlist;
    }

    public TeacherEntity() {
    }

    public TeacherEntity(String name, String surname, String parentName, int idDepartament) {
        this.name = name;
        this.surname = surname;
        this.parentName = parentName;
        this.idDepartament = idDepartament;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public int getIdDepartament() {
        return idDepartament;
    }

    public void setIdDepartament(int idDepartament) {
        this.idDepartament = idDepartament;
    }

    public DepartamentEntity getDepartamentEntity() {
        return departamentEntity;
    }

    public void setDepartamentEntity(DepartamentEntity departamentEntity) {
        this.departamentEntity = departamentEntity;
    }
}
