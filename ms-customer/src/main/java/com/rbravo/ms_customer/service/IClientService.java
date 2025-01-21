package com.rbravo.ms_customer.service;

import com.rbravo.ms_customer.model.dto.ClientRequestDTO;
import com.rbravo.ms_customer.model.dto.ClientResponseDTO;
import com.rbravo.ms_customer.model.dto.ClientUpdateDTO;

import java.util.List;

public interface IClientService {

    ClientResponseDTO create(ClientRequestDTO clientRequestDTO);

    ClientResponseDTO findById(Long id);

    List<ClientResponseDTO> findAll();

    ClientResponseDTO update(Long id, ClientUpdateDTO clientUpdateDTO);

    void delete(Long id);
}
