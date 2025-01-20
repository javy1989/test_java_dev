package com.rbravo.ms_management.controller.rest;

import com.rbravo.ms_management.model.dto.ClientDTO;
import com.rbravo.ms_management.model.dto.ClientUpdateDTO;
import com.rbravo.ms_management.model.service.IClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    @Autowired
    private IClientService clientService;

    /**
     * Create a new Client.
     *
     * @param client the ClientDTO to create.
     * @return the created ClientDTO.
     */
    @PostMapping
    public ClientDTO createClient(@Valid @RequestBody ClientDTO client) {
        return clientService.create(client);
    }

    /**
     * Get a Client by ID.
     *
     * @param clientId the ID of the Client.
     * @return the ClientDTO if found.
     */
    @GetMapping("/{clientId}")
    public ClientDTO getClientById(@PathVariable Long clientId) {
        return clientService.findByid(clientId);
    }

    /**
     * Get all Clients.
     *
     * @return a list of all ClientDTOs.
     */
    @GetMapping
    public List<ClientDTO> getAllClients() {
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
    public ClientDTO updateClient(@PathVariable Long clientId, @Valid @RequestBody ClientUpdateDTO payload) {
        return clientService.update(clientId, payload);
    }

    /**
     * Delete a Client by ID.
     *
     * @param clientId the ID of the Client to delete.
     */
    @DeleteMapping("/{clientId}")
    public void deleteClient(@PathVariable Long clientId) {
        clientService.delete(clientId);
    }
}

