package com.example.movieBE.service.admin;

import com.example.movieBE.dto.ResponseTemplate;
import com.example.movieBE.dto.UserDto;
import com.example.movieBE.entity.UserEntity;
import com.example.movieBE.entity.UserRoleEntity;
import com.example.movieBE.form.UpdatePasswordForm;

import java.util.List;

public interface UserService {
    /**
     *
     * @return
     */
    ResponseTemplate getUser();

    ResponseTemplate updateUser(UserDto form);

    ResponseTemplate deleteUserById(Long idUser);

    ResponseTemplate getUserByUserName(String userName);

    ResponseTemplate updateUserPassword(UpdatePasswordForm form);

    UserEntity findUserByUserName(String userName);

    UserEntity saveUser(UserEntity user);

    List<UserRoleEntity> findRole();
}
