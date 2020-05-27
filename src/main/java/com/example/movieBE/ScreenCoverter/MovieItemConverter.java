package com.example.movieBE.ScreenCoverter;


import com.example.movieBE.ScreenDto.MovieItemDto;
import com.example.movieBE.converter.*;
import com.example.movieBE.entity.MovieEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * DTO to Entity and Entity to DTO Conversion
 */
@Component
public class MovieItemConverter implements BaseConverter<MovieItemDto, MovieEntity> {

    @Override
    public MovieItemDto toDTO(final MovieEntity entity) {
        if(Objects.isNull(entity)){
            return null;
        }
        final MovieItemDto dto = new MovieItemDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSlug(entity.getSlug());
        dto.setDescription(entity.getDescription());
        dto.setRelease_year(entity.getRelease_year());
        dto.setRate(entity.getRate());
        return dto;
    }

    /**
     *
     */
    @Override
    public MovieEntity toEntity(final MovieItemDto dto) {

        final MovieEntity entity = new MovieEntity();

        return updateEntity(entity, dto);
    }

    /**
     *
     */
    @Override
    public MovieEntity updateEntity(final MovieEntity entity, final MovieItemDto dto) {
        if(Objects.isNull(dto)){
            return null;
        }
        entity.setName(dto.getName());
        entity.setSlug(dto.getSlug());
        entity.setDescription(dto.getDescription());
        entity.setRelease_year(dto.getRelease_year());
        entity.setRate(dto.getRate());
        return entity;
    }

}

