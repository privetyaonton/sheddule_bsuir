package com.example.shed_bsuir_spring.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "academic_subject")
public class AcademicSubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_academic_subject")
    private int id;

    @Column (name = "name")
    private String name;
    public AcademicSubjectEntity(){}
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
}
