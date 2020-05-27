package com.example.movieBE.service.admin;

import com.example.movieBE.dto.ResponseTemplate;
import com.example.movieBE.dto.UserRoleDto;
import com.example.movieBE.entity.UserRoleEntity;
import com.example.movieBE.response.Pagination;

public interface UserRoleService {
    ResponseTemplate getAllUserRoles(Pagination pagination);

    ResponseTemplate getUserRole();

    UserRoleDto getFullUserRole(UserRoleEntity entity);

    ResponseTemplate updateUserRole(UserRoleDto form);

    ResponseTemplate deletedUserRoleById(Long id);
}
