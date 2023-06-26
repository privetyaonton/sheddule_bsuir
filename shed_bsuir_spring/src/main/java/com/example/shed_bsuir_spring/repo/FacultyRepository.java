package com.example.shed_bsuir_spring.repo;

import com.example.shed_bsuir_spring.entity.FacultyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<FacultyEntity, Long> {
    public FacultyEntity findById (int id);
    public boolean existsById (int id);
    @Override @NonNull
    List<FacultyEntity> findAll();
    @Override @NonNull
    <S extends FacultyEntity> S save(@NonNull S entity);
    @Override
    void deleteById(@NonNull Long aLong);
}
