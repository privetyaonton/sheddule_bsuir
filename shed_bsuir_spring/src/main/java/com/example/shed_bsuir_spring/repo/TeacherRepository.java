package com.example.shed_bsuir_spring.repo;

import com.example.shed_bsuir_spring.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository <TeacherEntity, Long> {
    public TeacherEntity findById (int id);
    public boolean existsById (int id);
}
