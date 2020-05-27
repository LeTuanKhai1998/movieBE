package com.example.movieBE.repository;

import com.example.movieBE.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ImageRepository extends JpaRepository<ImageEntity, Long>, JpaSpecificationExecutor<ImageEntity> {

}
