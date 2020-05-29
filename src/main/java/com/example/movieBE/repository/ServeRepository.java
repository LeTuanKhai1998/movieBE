package com.example.movieBE.repository;

import com.example.movieBE.entity.ServeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServeRepository extends JpaRepository<ServeEntity, Long>, JpaSpecificationExecutor<ServeEntity> {

    @Query(value = " SELECT ae " +
            " FROM ServeEntity ae " +
            " JOIN TypeServeEntity tse ON tse.id = ae.type_id " +
            " WHERE  ae.movie_id = :id " +
            " AND tse.name = :typeName ")
    List<ServeEntity> getServeHasMovie(Long id, String typeName);

    @Modifying
    @Query(value = " DELETE FROM ServeEntity a WHERE a.movie_id = :movieId ")
    void deleteServeHasMovie(Long movieId);

    @Modifying
    @Query(value = " INSERT INTO serve (movie_id,type_id, url) VALUES (:movieId, :typeId,:url) ", nativeQuery = true)
    void saveServeHasMovie(Long movieId, Long typeId, String url);
}
