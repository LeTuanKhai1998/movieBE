package com.example.movieBE.repository;

import com.example.movieBE.entity.ImageUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ImageUserRepository extends JpaRepository<ImageUserEntity, Long>, JpaSpecificationExecutor<ImageUserEntity> {
}
