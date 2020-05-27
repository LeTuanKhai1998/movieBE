package com.example.movieBE.converter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 *
 * @param <DTO>
 * @param <Entity>
 */
public interface BaseConverter<DTO, Entity> {

    /**
     *
     * @param entity
     * @return
     */
    DTO toDTO(final Entity entity);

    /**
     *
     * @param dto
     * @return
     */
    Entity toEntity(final DTO dto);

    /**
     *
     * @param entity
     * @param dto
     * @return
     */
    Entity updateEntity(final Entity entity, final DTO dto);

    /**
     *
     * @param entities
     * @return
     */
    default List<DTO> toDTO(final Collection<Entity> entities) {
        return entities.stream().map(this::toDTO).collect(Collectors.toList());
    }

    /**
     *
     * @param dtos
     * @return
     */
    default List<Entity> toEntity(final Collection<DTO> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

}