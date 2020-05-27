package com.example.movieBE.repository;

import com.example.movieBE.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GenreRepository extends JpaRepository<GenreEntity, Long>, JpaSpecificationExecutor<GenreEntity> {
    @Query(value = " SELECT ge " +
            " FROM GenreEntity ge" +
            " JOIN GenreHasMovieEntity ghme ON ge.id = ghme.genre_id" +
            " WHERE  ghme.movie_id = :movieId")
    List<GenreEntity> getGenreHasMovie(Long movieId);

    @Modifying
    @Query(value = " DELETE FROM GenreHasMovieEntity ghme WHERE  ghme.movie_id = :movieId ")
    void deleteGenreHasMovie(Long movieId);

    @Modifying
    @Query(value = " INSERT INTO genre_has_movie (movie_id, genre_id) VALUES (:movieId, :genreId) ",nativeQuery = true)
    void saveGenreHasMovie(Long movieId, Long genreId);
}
