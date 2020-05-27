package com.example.movieBE.service.admin;

import com.example.movieBE.dto.ResponseTemplate;
import com.example.movieBE.dto.UserDto;

public interface UserService {
    /**
     *
     * @return
     */
    ResponseTemplate getUser();

    ResponseTemplate updateUser(UserDto form);

    ResponseTemplate deleteUserById(Long idUser);
}
