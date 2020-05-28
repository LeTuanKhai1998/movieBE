package com.example.movieBE.repository;

import com.example.movieBE.dto.UserDto;
import com.example.movieBE.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {

    @Query(value = " select new com.example.movieBE.dto.UserDto(ue,ce,iue,ure)" +
            " from UserEntity ue, CountryEntity ce, ImageUserEntity iue, UserRoleEntity ure " +
            " WHERE ue.country_id = ce.id " +
            " AND ue.avatar_id = iue.id " +
            " AND ue.user_role_id = ure.id " +
            " ORDER BY ue.id DESC ")
    List<UserDto> getAll();
    UserEntity findByEmail(String email);
    UserEntity findByUsername(String userName);
}
