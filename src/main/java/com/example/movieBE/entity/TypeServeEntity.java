package com.example.movieBE.entity;


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
@Table(name = "type_serve")
public class TypeServeEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Basic@Column(name = "name")
    private String name;

    @Basic@Column(name = "create_time")
    private Instant create_time;

    @Basic@Column(name = "update_time")
    private Instant update_time;
}
