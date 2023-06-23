package com.example.shed_bsuir_spring.repo;

import com.example.shed_bsuir_spring.entity.FacultyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<FacultyEntity, Long> {
    public FacultyEntity findById (int id);
    public boolean existsById (int id);
}
