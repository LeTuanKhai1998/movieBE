package com.example.movieBE.converter;

import com.example.movieBE.dto.UserRoleDto;
import com.example.movieBE.entity.UserRoleEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserRoleConverter implements BaseConverter<UserRoleDto, UserRoleEntity> {
    @Override
    public UserRoleDto toDTO(UserRoleEntity entity) {
        if(Objects.isNull(entity)){
            return null;
        }
        final UserRoleDto dto = new UserRoleDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    @Override
    public UserRoleEntity toEntity(UserRoleDto dto) {
        final UserRoleEntity entity = new UserRoleEntity();

        return updateEntity(entity, dto);
    }

    @Override
    public UserRoleEntity updateEntity(UserRoleEntity entity, UserRoleDto dto) {
        if(Objects.isNull(dto)){
            return null;
        }
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        return entity;
    }

}
