package com.example.movieBE.converter;

import com.example.movieBE.dto.DirectorDto;
import com.example.movieBE.entity.DirectorEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * DTO to Entity and Entity to DTO Conversion
 */
@Component
public class DirectorConverter implements BaseConverter<DirectorDto, DirectorEntity> {

    /**
     *
     */
    @Override
    public DirectorDto toDTO(final DirectorEntity entity) {
        if(Objects.isNull(entity)){
            return null;
        }
        final DirectorDto dto = new DirectorDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setBirthday(entity.getBirthday());
        return dto;
    }

    /**
     *
     */
    @Override
    public DirectorEntity toEntity(final DirectorDto dto) {

        final DirectorEntity entity = new DirectorEntity();

        return updateEntity(entity, dto);
    }

    /**
     *
     */
    @Override
    public DirectorEntity updateEntity(final DirectorEntity entity, final DirectorDto dto) {
        if(Objects.isNull(dto)){
            return null;
        }
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setBirthday(dto.getBirthday());
        return entity;
    }

}
