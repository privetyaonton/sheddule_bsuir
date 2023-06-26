package com.example.shed_bsuir_spring.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "groups")
public class GroupEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_group")
    private int id;
    @Column (name = "number_group")
    private String numberGroup;
    @ManyToOne
    @JoinColumn (name = "id_speciallity", referencedColumnName = "id_speciallity")
    private SpeciallityEntity speciallityEntity;
}
