package com.example.movieBE.converter;

import com.example.movieBE.dto.PermissionTabDto;
import com.example.movieBE.entity.PermissionTabEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PermissionTabConverter implements BaseConverter<PermissionTabDto, PermissionTabEntity> {
    @Override
    public PermissionTabDto toDTO(PermissionTabEntity entity) {
        if(Objects.isNull(entity)){
            return null;
        }
        final PermissionTabDto dto = new PermissionTabDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    @Override
    public PermissionTabEntity toEntity(PermissionTabDto dto) {
        final PermissionTabEntity entity = new PermissionTabEntity();

        return updateEntity(entity, dto);
    }

    @Override
    public PermissionTabEntity updateEntity(PermissionTabEntity entity, PermissionTabDto dto) {
        if(Objects.isNull(dto)){
            return null;
        }
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }
}
