package com.example.movieBE.converter;

import com.example.movieBE.dto.ImageDto;
import com.example.movieBE.entity.ImageEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * DTO to Entity and Entity to DTO Conversion
 */
@Component
public class ImageConverter implements BaseConverter<ImageDto, ImageEntity> {

    /**
     *
     */
    @Override
    public ImageDto toDTO(final ImageEntity entity) {
        if(Objects.isNull(entity)){
            return null;
        }
        final ImageDto dto = new ImageDto();
        dto.setId(entity.getId());
        dto.setUrl(entity.getUrl());
        dto.setAlt(entity.getAlt());
        return dto;
    }

    /**
     *
     */
    @Override
    public ImageEntity toEntity(final ImageDto dto) {

        final ImageEntity entity = new ImageEntity();

        return updateEntity(entity, dto);
    }

    /**
     *
     */
    @Override
    public ImageEntity updateEntity(final ImageEntity entity, final ImageDto dto) {
        if(Objects.isNull(dto)){
            return null;
        }
        entity.setId(dto.getId());
        entity.setUrl(dto.getUrl());
        entity.setAlt(dto.getAlt());
        return entity;
    }

}

