package com.rbravo.ms_customer.service;

import com.rbravo.ms_customer.model.dto.ClientRequestDTO;
import com.rbravo.ms_customer.model.dto.ClientResponseDTO;
import com.rbravo.ms_customer.model.dto.ClientUpdateDTO;

import java.util.List;

/**
 * Interface for client services
 */
public interface IClientService {

    /**
     * Create a client
     *
     * @param clientRequestDTO the payload client
     * @return to {@link ClientResponseDTO}
     */
    ClientResponseDTO create(ClientRequestDTO clientRequestDTO);

    /**
     * Search for a customer by their ID
     *
     * @param id the id client
     * @return to {@link ClientResponseDTO}
     */
    ClientResponseDTO findById(Long id);

    /**
     * Search all clients
     *
     * @return to {@link List<ClientResponseDTO>}
     */
    List<ClientResponseDTO> findAll();

    /**
     * Update information a client
     *
     * @param id              the id client
     * @param clientUpdateDTO payload client request
     * @return to {@link ClientResponseDTO}
     */
    ClientResponseDTO update(Long id, ClientUpdateDTO clientUpdateDTO);

    /**
     * Delete a client
     *
     * @param id the id client
     */
    void delete(Long id);
}
