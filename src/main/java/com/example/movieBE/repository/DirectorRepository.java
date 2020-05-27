package com.example.movieBE.repository;

import com.example.movieBE.entity.DirectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DirectorRepository extends JpaRepository<DirectorEntity, Long>, JpaSpecificationExecutor<DirectorEntity> {

    @Query(value = " SELECT de " +
            " FROM DirectorEntity de" +
            " JOIN DirectorHasMovieEntity dhme ON de.id = dhme.director_id " +
            " WHERE  dhme.movie_id = :movieId")
    List<DirectorEntity> getDirectorHasMovie(Long movieId);

    @Modifying
    @Query(value = " DELETE FROM DirectorHasMovieEntity dhme WHERE  dhme.movie_id = :movieId ")
    void deleteDirectorHasMovie(Long movieId);

    @Modifying
    @Query(value = " INSERT INTO director_has_movie (movie_id, director_id) VALUES (:movieId, :directorId) ",nativeQuery = true)
    void saveDirectorHasMovie(Long movieId, Long directorId);
}
