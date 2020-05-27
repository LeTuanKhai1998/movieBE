package com.example.movieBE.entity;



import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@EntityListeners(AuditingEntityListener.class)
@CrossOrigin( origins = "*")
@Table(name = "users")
public class UserEntity implements Serializable {

    @Id@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic@Column(name = "user_role_id")
    private Long user_role_id;

    @Basic@Column(name = "avatar_id")
    private Long avatar_id;

    @Basic@Column(name = "firstname")
    private String firstname;

    @Basic@Column(name = "lastname")
    private String lastname;

    @Basic@Column(name = "email")
    private String email;

    @Basic@Column(name = "country_id")
    private Long country_id;

    @Basic@Column(name = "username",unique = true,nullable = false)
    private String username;

    @Basic@Column(name = "password",nullable = false)
    private String password;

}
