package com.example.shed_bsuir_spring.service;

import com.example.shed_bsuir_spring.dto.TeacherDTO;
import com.example.shed_bsuir_spring.entity.TeacherEntity;
import com.example.shed_bsuir_spring.repo.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

}
