package com.example.movieBE.repository;

import com.example.movieBE.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserRoleRepository  extends JpaRepository<UserRoleEntity, Long>{
    @Query("select id from UserRoleEntity where name = :role")
    Long findIdByRoleName(String role);


    UserRoleEntity findUserRoleEntityById(Long idRole);

    List<UserRoleEntity> findAll();
}
