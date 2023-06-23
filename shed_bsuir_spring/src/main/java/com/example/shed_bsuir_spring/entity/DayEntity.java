package com.example.shed_bsuir_spring.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "day")
public class DayEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_day")
    private int id;

    @Column (name = "code")
    private int code;
    public DayEntity(){}
    public int getId(){
        return id;
    }
    public int getCode(){
        return code;
    }
    public void setId (int id){
        this.id = id;
    }
    public void setCode(int code){
        this.code = code;
    }
}
