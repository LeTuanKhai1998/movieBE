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
@CrossOrigin( origins = "*")
@Table(name = "permission_has_user_role")
public class PermissionHasUserRoleEntity implements Serializable {
    @Id
    @Column(name = "user_role_id")
    private Long user_role_id;

    @Id
    @Column(name = "permission_tab_id")
    private Long permission_tab_id;

}
