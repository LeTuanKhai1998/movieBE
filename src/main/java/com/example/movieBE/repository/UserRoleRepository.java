package com.example.movieBE.repository;

import com.example.movieBE.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRoleRepository  extends JpaRepository<UserRoleEntity, Long>, JpaSpecificationExecutor<UserRoleEntity> {
}
