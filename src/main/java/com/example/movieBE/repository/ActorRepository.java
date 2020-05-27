package com.example.movieBE.repository;

import com.example.movieBE.entity.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface ActorRepository extends JpaRepository<ActorEntity, Long>, JpaSpecificationExecutor<ActorEntity> {


    @Query(value = " SELECT ae " +
            " FROM ActorEntity ae" +
            " JOIN ActorHasMovieEntity ahme ON ae.id = ahme.actor_id" +
            " WHERE  ahme.movie_id = :movieId")
    List<ActorEntity> getActorHasMovie(Long movieId);

    @Modifying
    @Query(value = " DELETE FROM ActorHasMovieEntity a WHERE a.movie_id = :movieId ")
    void deleteActorHasMovie(Long movieId);

    @Modifying
    @Query(value = " INSERT INTO actor_has_movie (movie_id, actor_id) VALUES (:movieId, :actorId) ",nativeQuery = true)
    void saveActorHasMovie(Long movieId,Long actorId);
}
