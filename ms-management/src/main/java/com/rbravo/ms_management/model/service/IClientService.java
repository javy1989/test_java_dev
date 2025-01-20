package com.rbravo.ms_management.model.service;

import com.rbravo.ms_management.model.dto.ClientDTO;
import com.rbravo.ms_management.model.dto.ClientUpdateDTO;

public interface IClientService extends ICrudService<ClientDTO, Long> {

    ClientDTO create(ClientDTO clientDTO);

    ClientDTO update(Long id, ClientUpdateDTO clientDTO);
}
