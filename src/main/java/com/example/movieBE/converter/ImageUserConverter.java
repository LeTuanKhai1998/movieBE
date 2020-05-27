package com.example.movieBE.converter;

import com.example.movieBE.dto.ImageUserDto;
import com.example.movieBE.entity.ImageUserEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ImageUserConverter implements BaseConverter<ImageUserDto, ImageUserEntity> {

    /**
     *
     */
    @Override
    public ImageUserDto toDTO(final ImageUserEntity entity) {
        if(Objects.isNull(entity)){
            return null;
        }
        final ImageUserDto dto = new ImageUserDto();
        dto.setId(entity.getId());
        dto.setUrl(entity.getUrl());
        dto.setAlt(entity.getAlt());
        return dto;
    }

    /**
     *
     */
    @Override
    public ImageUserEntity toEntity(final ImageUserDto dto) {

        final ImageUserEntity entity = new ImageUserEntity();

        return updateEntity(entity, dto);
    }

    /**
     *
     */
    @Override
    public ImageUserEntity updateEntity(final ImageUserEntity entity, final ImageUserDto dto) {
        if(Objects.isNull(dto)){
            return null;
        }
        entity.setUrl(dto.getUrl());
        entity.setAlt(dto.getAlt());
        return entity;
    }

}
