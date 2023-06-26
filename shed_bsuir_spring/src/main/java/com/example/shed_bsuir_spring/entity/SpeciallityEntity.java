package com.example.shed_bsuir_spring.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "speciallity")
public class SpeciallityEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_speciallity")
    private int id;

    @Column (name = "name")
    private String name;

    @ManyToOne
    @JoinColumn (name = "id_faculty", referencedColumnName = "id_faculty")
    private FacultyEntity facultyEntity;

    public SpeciallityEntity(FacultyEntity facultyEntity, String name) {
        this.name = name;
        this.facultyEntity = facultyEntity;
    }



    public SpeciallityEntity() {
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

    public FacultyEntity getFacultyEntity() {
        return facultyEntity;
    }

    public void setFacultyEntity(FacultyEntity facultyEntity) {
        this.facultyEntity = facultyEntity;
    }
}
