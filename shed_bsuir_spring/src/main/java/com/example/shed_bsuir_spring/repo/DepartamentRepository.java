package com.example.shed_bsuir_spring.repo;

import com.example.shed_bsuir_spring.entity.DepartamentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentRepository extends JpaRepository <DepartamentEntity, Long> {
    public DepartamentEntity findById (int id);
    public boolean existsById (int id);
    @Override
    @NonNull <S extends DepartamentEntity> S save(@NonNull S entity);
}
