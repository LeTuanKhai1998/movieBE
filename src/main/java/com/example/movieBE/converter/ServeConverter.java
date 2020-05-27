package com.example.movieBE.converter;

import com.example.movieBE.dto.ServeDto;
import com.example.movieBE.entity.ServeEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ServeConverter implements BaseConverter<ServeDto, ServeEntity>{
    @Override
    public ServeDto toDTO(ServeEntity entity) {
        if(Objects.isNull(entity)){
            return null;
        }
        final ServeDto dto = new ServeDto();
        dto.setId(entity.getId());
        dto.setUrl(entity.getUrl());
        return dto;
    }

    @Override
    public ServeEntity toEntity(ServeDto dto) {
        final ServeEntity entity = new ServeEntity();

        return updateEntity(entity, dto);
    }

    @Override
    public ServeEntity updateEntity(ServeEntity entity, ServeDto dto) {
        if(Objects.isNull(dto)){
            return null;
        }
        entity.setId(dto.getId());
        entity.setUrl(dto.getUrl());
        return entity;
    }
}
