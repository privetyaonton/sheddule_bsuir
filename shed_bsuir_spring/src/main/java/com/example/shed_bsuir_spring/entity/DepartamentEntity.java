package com.example.shed_bsuir_spring.entity;

import com.example.shed_bsuir_spring.dto.FacultyDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "departaments")
public class DepartamentEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_departament")
    private int id;
    @Column (name = "name")
    private String name;

    @ManyToOne ()
    @JoinColumn (name = "id_faculty", referencedColumnName = "id_faculty")
    private FacultyEntity facultyEntity;

    @OneToMany (mappedBy = "departamentEntity", cascade = CascadeType.ALL,
    orphanRemoval = true)
    private List<TeacherEntity> teacherEntityList = new ArrayList<>();

    public List<TeacherEntity> getTeacherEntityList() {
        return teacherEntityList;
    }

    public void setTeacherEntityList(List<TeacherEntity> teacherEntityList) {
        this.teacherEntityList = teacherEntityList;
    }

    public DepartamentEntity() {
    }

    public DepartamentEntity(String name, FacultyEntity facultyEntity) {
        this.name = name;
        this.facultyEntity = facultyEntity;
    }

    public FacultyEntity getFacultyEntity(){
        return facultyEntity;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setFacultyEntity(FacultyEntity facultyEntity) {
        this.facultyEntity = facultyEntity;
    }
}
