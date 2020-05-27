package com.example.movieBE.converter;

import com.example.movieBE.dto.ActorDto;
import com.example.movieBE.entity.ActorEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * DTO to Entity and Entity to DTO Conversion
 */
@Component
public class ActorConverter implements BaseConverter<ActorDto, ActorEntity> {

    /**
     *
     */
    @Override
    public ActorDto toDTO(final ActorEntity entity) {
        if(Objects.isNull(entity)){
            return null;
        }
        final ActorDto dto = new ActorDto();
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
    public ActorEntity toEntity(final ActorDto dto) {

        final ActorEntity entity = new ActorEntity();

        return updateEntity(entity, dto);
    }

    /**
     *
     */
    @Override
    public ActorEntity updateEntity(final ActorEntity entity, final ActorDto dto) {
        if(Objects.isNull(dto)){
            return null;
        }
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setBirthday(dto.getBirthday());
        return entity;
    }

}
