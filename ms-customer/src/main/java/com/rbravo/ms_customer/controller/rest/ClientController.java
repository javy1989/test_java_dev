package com.rbravo.ms_customer.controller.rest;

import com.rbravo.ms_customer.model.dto.ClientRequestDTO;
import com.rbravo.ms_customer.model.dto.ClientResponseDTO;
import com.rbravo.ms_customer.model.dto.ClientUpdateDTO;
import com.rbravo.ms_customer.service.IClientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for client
 */
@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    private final IClientService clientService;

    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * Create a new Client.
     *
     * @param client the ClientDTO to create.
     * @return the created ClientDTO.
     */
    @PostMapping
    public ResponseEntity<ClientResponseDTO> create(@Valid @RequestBody ClientRequestDTO client) {
        return ResponseEntity.status(201).body(clientService.create(client));
    }

    /**
     * Get a Client by ID.
     *
     * @param clientId the ID of the Client.
     * @return the ClientDTO if found.
     */
    @GetMapping("/{clientId}")
    public ResponseEntity<ClientResponseDTO> getClientById(@PathVariable Long clientId) {
        return ResponseEntity.ok(clientService.findById(clientId));
    }

    /**
     * Get all Clients.
     *
     * @return a list of all ClientDTOs.
     */
    @GetMapping
    public List<ClientResponseDTO> getAll() {
        return clientService.findAll();
    }

    /**
     * Update a Client partially.
     *
     * @param clientId the ID of the Client to update.
     * @param payload  the fields to update.
     * @return the updated ClientDTO.
     */
    @PutMapping("/{clientId}")
    public ResponseEntity<ClientResponseDTO> update(@PathVariable Long clientId, @Valid @RequestBody ClientUpdateDTO payload) {
        return ResponseEntity.ok(clientService.update(clientId, payload));
    }

    /**
     * Delete a Client by ID.
     *
     * @param clientId the ID of the Client to delete.
     */
    @DeleteMapping("/{clientId}")
    public void delete(@PathVariable Long clientId) {
        clientService.delete(clientId);
    }
}
