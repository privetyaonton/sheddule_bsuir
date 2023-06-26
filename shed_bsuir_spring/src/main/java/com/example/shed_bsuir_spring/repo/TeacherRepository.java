package com.example.shed_bsuir_spring.repo;

import com.example.shed_bsuir_spring.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository <TeacherEntity, Long> {
    public TeacherEntity findById (int id);
    public boolean existsById (int id);
    public void deleteById (int id);
    @Override
    List<TeacherEntity> findAll();
    @Override
    @NonNull
    <S extends TeacherEntity> S save(@NonNull S entity);
}
