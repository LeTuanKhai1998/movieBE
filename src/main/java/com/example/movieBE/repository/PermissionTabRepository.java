package com.example.movieBE.repository;

import com.example.movieBE.entity.PermissionTabEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PermissionTabRepository extends JpaRepository<PermissionTabEntity, Long>, JpaSpecificationExecutor<PermissionTabEntity> {

    @Query(value = " SELECT pte " +
            " FROM PermissionTabEntity pte" +
            " JOIN PermissionHasUserRoleEntity phure ON pte.id = phure.permission_tab_id" +
            " WHERE  phure.user_role_id = :id")
    List<PermissionTabEntity> getPermissionHasUserRole(Long id);

    @Modifying
    @Query(value = " DELETE FROM PermissionHasUserRoleEntity a WHERE a.user_role_id = :userRoleId ")
    void deletePermissionHasUserRole(Long userRoleId);

    @Modifying
    @Query(value = " INSERT INTO permission_has_user_role (user_role_id, permission_tab_id) VALUES (:userRoleId, :id) ",nativeQuery = true)
    void saveActorHasMovie(Long userRoleId, Long id);
}
