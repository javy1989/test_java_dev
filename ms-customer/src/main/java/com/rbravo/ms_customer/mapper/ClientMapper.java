package com.rbravo.ms_customer.mapper;


import com.rbravo.ms_customer.model.dto.ClientRequestDTO;
import com.rbravo.ms_customer.model.dto.ClientResponseDTO;
import com.rbravo.ms_customer.model.dto.ClientUpdateDTO;
import com.rbravo.ms_customer.model.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 * Represent mapper dto to client
 *
 * @author rbravo
 */
@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    Client toEntity(ClientRequestDTO dto);

    Client toEntity(ClientResponseDTO dto);

    void toEntityUpdate(ClientUpdateDTO dto, @MappingTarget Client client);

    ClientResponseDTO toDTO(Client client);
}
