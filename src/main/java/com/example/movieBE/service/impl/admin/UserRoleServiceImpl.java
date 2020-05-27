package com.example.movieBE.service.impl.admin;

import com.example.movieBE.converter.PermissionTabConverter;
import com.example.movieBE.converter.UserRoleConverter;
import com.example.movieBE.dto.*;
import com.example.movieBE.entity.*;
import com.example.movieBE.repository.PermissionTabRepository;
import com.example.movieBE.repository.UserRoleRepository;
import com.example.movieBE.response.Pagination;
import com.example.movieBE.service.admin.UserRoleService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private UserRoleConverter userRoleConverter;

    @Autowired
    private PermissionTabRepository permissionTabRepository;

    @Autowired
    private PermissionTabConverter permissionTabConverter;


    @Override
    public ResponseTemplate getAllUserRoles(Pagination pagination) {
        ResponseTemplate response = new ResponseTemplate();
        if (ObjectUtils.allNotNull(pagination)) {

            Page<UserRoleEntity> list = userRoleRepository.findAll(PageRequest.of(pagination.getCurrentPage() - 1,
                    pagination.getItemsPerPage(),
                    pagination.getSortOrder() ? Sort.Direction.ASC : Sort.Direction.DESC,
                    pagination.getSort()));
            response.setData("total", list.getTotalElements());
            List<UserRoleDto> dtos = new ArrayList<>();
            UserRoleDto item;

            if (ObjectUtils.allNotNull(list, list.getContent())) {
                for (UserRoleEntity userRoleEntity : list.getContent()) {
                    if (ObjectUtils.allNotNull(userRoleEntity)) {
                        item = getFullUserRole(userRoleEntity);
                        dtos.add(item);
                    }
                }
                response.setData("data", dtos);
            }
        }
        return response;
    }

    @Override
    public ResponseTemplate getUserRole() {
        ResponseTemplate response = new ResponseTemplate();
        List<UserRoleEntity> list = userRoleRepository.findAll();
        List<UserRoleDto> userRoleDtos = new ArrayList<>();
        UserRoleDto item;
        for (UserRoleEntity userRoleEntity : list) {
            if (ObjectUtils.allNotNull(userRoleEntity)) {
                item = getFullUserRole(userRoleEntity);
                userRoleDtos.add(item);
            }
        }
        response.setData("data", userRoleDtos);
        return response;
    }

    @Override
    public UserRoleDto getFullUserRole(UserRoleEntity entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        UserRoleDto roleDto;
        List<PermissionTabEntity> permissionTabs;
        roleDto = userRoleConverter.toDTO(entity);
        permissionTabs = permissionTabRepository.getPermissionHasUserRole(entity.getId());
        if (ObjectUtils.allNotNull(permissionTabs)) {
            roleDto.setPermissionTabs(permissionTabConverter.toDTO(permissionTabs));
        }
        return roleDto;
    }

    @Transactional(readOnly = false)
    @Override
    public ResponseTemplate updateUserRole(UserRoleDto form) {
        ResponseTemplate response = new ResponseTemplate();
        response.setData("data", "fail");
        if (ObjectUtils.allNotNull(form)) {
            UserRoleEntity userRoleUpdate = new UserRoleEntity();
            Long userRoleId = form.getId();
            if (userRoleId != 0) {
                userRoleUpdate = userRoleRepository.getOne(userRoleId);
            } else {
                userRoleUpdate.setId(userRoleId);
            }
            if (!ObjectUtils.allNotNull(userRoleUpdate)) {
                userRoleUpdate = new UserRoleEntity();
            }
            userRoleUpdate.setName(form.getName());
            userRoleUpdate.setDescription(form.getDescription());

            UserRoleEntity userRoleEntity = userRoleRepository.save(userRoleUpdate);
            if (ObjectUtils.allNotNull(userRoleEntity)) {
                userRoleId = userRoleEntity.getId();
            }
            if (userRoleId != 0) {
                permissionTabRepository.deletePermissionHasUserRole(userRoleId);
                if (ObjectUtils.allNotNull(form.getPermissionTabs())) {
                    for (PermissionTabDto permissionTabDto : form.getPermissionTabs()) {
                        permissionTabRepository.saveActorHasMovie(userRoleId, permissionTabDto.getId());
                    }
                }
            }
            response.setData("data", "successful");
        }
        return response;
    }

    @Transactional(readOnly = false)
    @Override
    public ResponseTemplate deletedUserRoleById(Long id) {
        ResponseTemplate response = new ResponseTemplate();
        response.setData("data", "fail");
        if (ObjectUtils.allNotNull(id) && id != 0) {
            permissionTabRepository.deletePermissionHasUserRole(id);
            userRoleRepository.deleteById(id);
            response.setData("data", "successful");
        }
        return response;
    }
}
