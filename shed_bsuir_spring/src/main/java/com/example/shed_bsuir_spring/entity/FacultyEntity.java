package com.example.shed_bsuir_spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "faculty")
public class FacultyEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_faculty")
    private int id;

    @Column (name = "full_name")
    private String full_name;
    @Column (name = "short_name")
    private String short_name;
    public FacultyEntity(){}

    public FacultyEntity(String full_name, String short_name) {
        this.full_name = full_name;
        this.short_name = short_name;
    }

    @OneToMany (mappedBy = "facultyEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DepartamentEntity> departamentEntitySet = new ArrayList<>();
    @OneToMany (mappedBy = "facultyEntity", cascade = CascadeType.ALL,
    orphanRemoval = true)
    private List<SpeciallityEntity> speciallityEntityList = new ArrayList<>();

    public List<SpeciallityEntity> getSpeciallityEntityList() {
        return speciallityEntityList;
    }

    public void setSpeciallityEntityList(List<SpeciallityEntity> speciallityEntityList) {
        this.speciallityEntityList = speciallityEntityList;
    }

    public List<DepartamentEntity> getDepartamentEntitySet (){
        return departamentEntitySet;
    }
    public void setDepartamentEntitySet (List<DepartamentEntity> departamentEntitySet){
        this.departamentEntitySet = departamentEntitySet;
    }
    public int getId(){
        return id;
    }
    public String getFull_name(){
        return full_name;
    }
    public String getShort_name(){
        return short_name;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setFull_name(String s){
        full_name = s;
    }
    public void setShort_name(String s){
        short_name = s;
    }
}
