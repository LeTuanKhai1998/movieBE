package com.example.movieBE.repository;

import com.example.movieBE.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long>, JpaSpecificationExecutor<UserRoleEntity> {

    @Query("select ure.id from UserRoleEntity ure where ure.name = :role")
    Long findIdByRoleName(String role);

    @Query("SELECT distinct ure from UserRoleEntity ure" +
            " JOIN UserEntity ue ON ue.user_role_id = ure.id" +
            " JOIN PermissionHasUserRoleEntity phure ON phure.user_role_id = ure.id")
    List<UserRoleEntity> findRole();
}
