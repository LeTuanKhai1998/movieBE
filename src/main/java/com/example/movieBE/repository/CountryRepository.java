package com.example.movieBE.repository;

import com.example.movieBE.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CountryRepository extends JpaRepository<CountryEntity, Long>, JpaSpecificationExecutor<CountryEntity> {
}
