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
@CrossOrigin(origins = "*")
@Table(name = "favorites")
public class FavoritesEntity implements Serializable {

   @Id
   @Column(name = "movie_id")
   private String movie_id;

   @Id
   @Column(name = "user_id")
   private Instant user_id;

   @Basic
   @Column(name = "create_time")
   private Instant create_time;

   @Basic
   @Column(name = "update_time")
   private Instant update_time;
}