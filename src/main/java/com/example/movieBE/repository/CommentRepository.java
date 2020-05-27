package com.example.movieBE.repository;

import com.example.movieBE.dto.CommentDto;
import com.example.movieBE.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;

public interface CommentRepository extends JpaRepository<CommentEntity, Long>, JpaSpecificationExecutor<CommentEntity> {


    @Query(value = " SELECT new com.example.movieBE.dto.CommentDto(ce,ue,iue) " +
            " FROM CommentEntity ce " +
            " JOIN UserEntity ue ON ce.user_id = ue.id" +
            " JOIN ImageUserEntity iue ON ue.avatar_id = iue.id" +
            " WHERE ce.movie_id =:movieId" +
            " ORDER BY ce.update_time DESC ")
    Page<CommentDto> getCommentByMovieId(Long movieId, Pageable pageable);
}
