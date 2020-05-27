package com.example.movieBE.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@CrossOrigin( origins = "*")
@Table(name = "comments")
public class CommentEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movie_id")
    private Long movie_id;

    @Column(name = "user_id")
    private Long user_id;

    @Basic@Column(name = "description")
    private String description;

    @Basic
    @Column(name = "create_time")
    private Instant create_time;

    @Basic
    @Column(name = "update_time")
    private Instant update_time;

    public CommentEntity(Long movie_id, Long user_id, String description, Instant create_time, Instant update_time) {
        this.movie_id = movie_id;
        this.user_id = user_id;
        this.description = description;
        this.create_time = create_time;
        this.update_time = update_time;
    }
}
