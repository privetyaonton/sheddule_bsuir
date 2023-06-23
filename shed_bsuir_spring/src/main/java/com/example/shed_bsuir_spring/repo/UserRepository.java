package com.example.shed_bsuir_spring.repo;

import com.example.shed_bsuir_spring.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>,
        CrudRepository<UserEntity, Long> {
    UserEntity findById (int id);
    @Override
    @NonNull <S extends UserEntity> S save(@NonNull S entity);
    boolean existsByEmail (String email);
    @Override
    void delete(@NonNull UserEntity entity);
    boolean existsById (int id);
    @Override
    @NonNull List<UserEntity> findAll();
}
