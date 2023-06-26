package com.example.shed_bsuir_spring.repo;

import com.example.shed_bsuir_spring.entity.SpeciallityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeciallityRepository extends JpaRepository <SpeciallityEntity, Long> {
    @Override
    @NonNull
    List<SpeciallityEntity> findAll();
    @Override
    @NonNull
    <S extends SpeciallityEntity> S save(@NonNull S entity);
    boolean existsById (int id);
    SpeciallityEntity findById (int id);
    void deleteById (int id);
}
