package com.example.movieBE.converter;

import com.example.movieBE.dto.UserDto;
import com.example.movieBE.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * DTO to Entity and Entity to DTO Conversion
 */
@Component
public class UserConverter implements BaseConverter<UserDto, UserEntity> {

    /**
     *
     */
    @Override
    public UserDto toDTO(final UserEntity entity) {
        if(Objects.isNull(entity)){
            return null;
        }
        final UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setFirstname(entity.getFirstname());
        dto.setLastname(entity.getLastname());
        dto.setEmail(entity.getEmail());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    /**
     *
     */
    @Override
    public UserEntity toEntity(final UserDto dto) {

        final UserEntity entity = new UserEntity();

        return updateEntity(entity, dto);
    }

    /**
     *
     */
    @Override
    public UserEntity updateEntity(final UserEntity entity, final UserDto dto) {
        if(Objects.isNull(dto)){
            return null;
        }
        entity.setId(dto.getId());
        entity.setUsername(dto.getUsername());
        entity.setFirstname(dto.getFirstname());
        entity.setLastname(dto.getLastname());
        entity.setEmail(dto.getEmail());
        entity.setDescription(dto.getDescription());
        if(Objects.nonNull(dto.getRole())) {
            entity.setUser_role_id(dto.getRole().getId());
        }
        if(Objects.nonNull(dto.getCountry())) {
            entity.setCountry_id(dto.getCountry().getId());
        }
        if(Objects.nonNull(dto.getAvatar())) {
            entity.setAvatar_id(dto.getAvatar().getId());
        }
        return entity;
    }

}