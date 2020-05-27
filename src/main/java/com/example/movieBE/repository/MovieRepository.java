package com.example.movieBE.repository;

import com.example.movieBE.constant.ProcedureName;
import com.example.movieBE.entity.MovieEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<MovieEntity, Long>, JpaSpecificationExecutor<MovieEntity> {

    @Query(value = " SELECT DISTINCT me.release_year " +
            " FROM MovieEntity me " +
            " order by me.release_year DESC ")
    List<Integer> getYear();

    @Query(value = " SELECT me " +
            " FROM MovieEntity me " +
            " WHERE me.name LIKE CONCAT('%',:name,'%') ")
    List<MovieEntity> findByName(String name, Pageable paging);

    @Query(nativeQuery = true, value = ProcedureName.getBanner)
        // call store procedure
    List<MovieEntity> getBanner();

    @Query(nativeQuery = true, value = ProcedureName.getBannerBottom)
    List<MovieEntity> getBannerBottom();

    @Query(nativeQuery = true, value = ProcedureName.getFeatured)
    List<MovieEntity> getFeatured();

    @Query(nativeQuery = true, value = ProcedureName.getTopRating)
    List<MovieEntity> getTopRating();

    @Query(nativeQuery = true, value = ProcedureName.getTopViewed)
    List<MovieEntity> getTopViewed();

    @Query(nativeQuery = true, value = ProcedureName.getRecentlyAdded)
    List<MovieEntity> getRecentlyAdded();

    @Query(value = " SELECT me " +
            " FROM MovieEntity me " +
            " WHERE me.slug = :slug")
    Optional<MovieEntity> getMovieBySlug(String slug);

    @Query(value = " SELECT me " +
            " FROM MovieEntity me ")
    List<MovieEntity> getMostPopularMovie(Pageable pageable);

    @Query(value = " SELECT me " +
            " FROM MovieEntity me " +
            " JOIN GenreHasMovieEntity ghme ON me.id = ghme.movie_id " +
            " JOIN GenreEntity ge ON ghme.genre_id = ge.id" +
            " WHERE ge.slug = :slug")
    Page<MovieEntity> getMovieByGenreSlug(String slug, Pageable paging);

    @Query(nativeQuery = true, value = ProcedureName.getTopViewByTime)
    List<MovieEntity> getTopViewByTime(String dateIn, String dateOut);
}
