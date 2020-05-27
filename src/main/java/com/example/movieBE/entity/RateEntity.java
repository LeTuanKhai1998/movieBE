package com.example.movieBE.entity;

import java.io.Serializable;
import java.time.Instant;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.CrossOrigin;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@CrossOrigin( origins = "*")
@Table(name = "rates")
public class RateEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Basic@Column(name = "movie_id")
    private Long movie_id;

    @Basic@Column(name = "user_id")
    private Long user_id;

    @Basic@Column(name = "title")
    private String title;

    @Basic@Column(name = "rate")
    private Integer rate;

    @Basic@Column(name = "description")
    private String description;

}
