package com.rbravo.ms_management.model.mapper;

import com.rbravo.ms_management.model.dto.ClientDTO;
import com.rbravo.ms_management.model.entity.Client;
import org.mapstruct.Mapper;

/**
 * Represent mapper dto to client
 *
 * @author rbravo
 */
@Mapper(componentModel = "spring")
public interface IClientMapper extends IGenericMapper<Client, ClientDTO> {
}
