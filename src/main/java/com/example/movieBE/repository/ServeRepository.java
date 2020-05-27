package com.example.movieBE.repository;

import com.example.movieBE.entity.ServeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServeRepository extends JpaRepository<ServeEntity, Long>, JpaSpecificationExecutor<ServeEntity> {

    @Query(value = " SELECT ae " +
            " FROM ServeEntity ae " +
            " JOIN TypeServeEntity tse ON tse.id = ae.type_id " +
            " WHERE  ae.movie_id = :id " +
            " AND tse.name = :typeName ")
    List<ServeEntity> getServeHasMovie(Long id, String typeName);
}
