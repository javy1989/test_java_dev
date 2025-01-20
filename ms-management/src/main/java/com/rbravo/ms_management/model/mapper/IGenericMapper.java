package com.rbravo.ms_management.model.mapper;

/**
 * Generi mapper for converting between Entity and DTO
 *
 * @param <Entity> the entity
 * @param <DTO>    the dto
 */
public interface IGenericMapper<Entity, DTO> {

    DTO toDTO(Entity entity);

    Entity toEntity(DTO dto);
}
