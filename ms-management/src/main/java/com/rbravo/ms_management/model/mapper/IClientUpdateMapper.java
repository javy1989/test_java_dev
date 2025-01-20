package com.rbravo.ms_management.model.mapper;

import com.rbravo.ms_management.model.dto.ClientUpdateDTO;
import com.rbravo.ms_management.model.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * Represent mapper dto to client update
 *
 * @author rbravo
 */
@Mapper(componentModel = "spring")
public interface IClientUpdateMapper {

    /**
     * Update fields of an existing Client entity using data from ClientDTO.
     *
     * @param clientDTO the source DTO
     * @param client    the target entity to update
     */
    void updateClientFromDTO(ClientUpdateDTO clientDTO, @MappingTarget Client client);
}
