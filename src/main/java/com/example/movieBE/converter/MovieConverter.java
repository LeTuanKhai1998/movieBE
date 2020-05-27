package com.example.movieBE.converter;


import com.example.movieBE.dto.MovieDto;
import com.example.movieBE.entity.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * DTO to Entity and Entity to DTO Conversion
 */
@Component
public class MovieConverter implements BaseConverter<MovieDto, MovieEntity> {


    /**
     *
     */
    @Override
    public MovieDto toDTO(final MovieEntity entity) {
        if(Objects.isNull(entity)){
            return null;
        }
        final MovieDto dto = new MovieDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSlug(entity.getSlug());
        dto.setDescription(entity.getDescription());
        dto.setRelease_year(entity.getRelease_year());
        dto.setNum_view(entity.getNum_view());
        dto.setRun_time(entity.getRun_time());
        dto.setRate(entity.getRate());
        dto.setNum_rate(entity.getNum_rate());

        return dto;
    }

    /**
     *
     */
    @Override
    public MovieEntity toEntity(final MovieDto dto) {

        final MovieEntity entity = new MovieEntity();

        return updateEntity(entity, dto);
    }

    /**
     *
     */
    @Override
    public MovieEntity updateEntity(final MovieEntity entity, final MovieDto dto) {
        if(Objects.isNull(dto)){
            return null;
        }
        entity.setId(dto.getId());
        if(Objects.nonNull(dto.getCountry())) {
            entity.setCountry_id(dto.getCountry().getId());
        }
        if(Objects.nonNull(dto.getBanner())) {
            entity.setBanner_id(dto.getBanner().getId());
        }
        if(Objects.nonNull(dto.getImage())) {
            entity.setImage_id(dto.getImage().getId());
        }
        entity.setName(dto.getName());
        entity.setSlug(dto.getSlug());
        entity.setDescription(dto.getDescription());
        entity.setRelease_year(dto.getRelease_year());
        entity.setNum_view(dto.getNum_view());
        entity.setRun_time(dto.getRun_time());
        entity.setRate(dto.getRate());
        entity.setNum_rate(dto.getNum_rate());
        return entity;
    }

}

