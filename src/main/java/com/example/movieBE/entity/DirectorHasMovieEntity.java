package com.example.movieBE.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@CrossOrigin(origins = "*")
@Table(name = "director_has_movie")
public class DirectorHasMovieEntity implements Serializable {

    @Id
    @Column(name = "movie_id")
    private Long movie_id;

    @Id
    @Column(name = "director_id")
    private Long director_id;

}