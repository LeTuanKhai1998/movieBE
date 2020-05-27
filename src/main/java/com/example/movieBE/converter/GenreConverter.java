package com.example.movieBE.converter;

import com.example.movieBE.dto.GenreDto;
import com.example.movieBE.entity.GenreEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class GenreConverter implements BaseConverter<GenreDto, GenreEntity> {

    /**
     *
     */
    @Override
    public GenreDto toDTO(final GenreEntity entity) {
        if(Objects.isNull(entity)){
            return null;
        }
        final GenreDto dto = new GenreDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSlug(entity.getSlug());
        return dto;
    }

    /**
     *
     */
    @Override
    public GenreEntity toEntity(final GenreDto dto) {

        final GenreEntity entity = new GenreEntity();

        return updateEntity(entity, dto);
    }

    /**
     *
     */
    @Override
    public GenreEntity updateEntity(final GenreEntity entity, final GenreDto dto) {
        if(Objects.isNull(dto)){
            return null;
        }
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setSlug(dto.getSlug());
        return entity;
    }

}