package com.example.movieBE.converter;

import com.example.movieBE.dto.CountryDto;
import com.example.movieBE.entity.CountryEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * DTO to Entity and Entity to DTO Conversion
 */
@Component
public class CountryConverter implements BaseConverter<CountryDto, CountryEntity> {

    /**
     *
     */
    @Override
    public CountryDto toDTO(final CountryEntity entity) {
        if(Objects.isNull(entity)){
            return null;
        }
        final CountryDto dto = new CountryDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    /**
     *
     */
    @Override
    public CountryEntity toEntity(final CountryDto dto) {

        final CountryEntity entity = new CountryEntity();

        return updateEntity(entity, dto);
    }

    /**
     *
     */
    @Override
    public CountryEntity updateEntity(final CountryEntity entity, final CountryDto dto) {
        if(Objects.isNull(dto)){
            return null;
        }
        entity.setName(dto.getName());
        return entity;
    }

}
