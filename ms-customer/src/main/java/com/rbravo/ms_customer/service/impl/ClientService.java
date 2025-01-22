package com.rbravo.ms_customer.service.impl;

import com.rbravo.ms_customer.mapper.ClientMapper;
import com.rbravo.ms_customer.messaging.producer.ClientCreateProducer;
import com.rbravo.ms_customer.model.dto.ClientRequestDTO;
import com.rbravo.ms_customer.model.dto.ClientResponseDTO;
import com.rbravo.ms_customer.model.dto.ClientUpdateDTO;
import com.rbravo.ms_customer.model.entity.Client;
import com.rbravo.ms_customer.repository.IClientRepository;
import com.rbravo.ms_customer.service.IClientService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Class for a client's transactions
 */
@Service
public class ClientService implements IClientService {

    private final IClientRepository repository;
    private final ClientMapper mapper;
    private final ClientCreateProducer clientCreateProducer;

    @Autowired
    public ClientService(IClientRepository repository, ClientMapper mapper, ClientCreateProducer clientCreateProducer) {
        this.repository = repository;
        this.mapper = mapper;
        this.clientCreateProducer = clientCreateProducer;
    }

    @Override
    public ClientResponseDTO create(ClientRequestDTO clientRequestDTO) {
        Optional<Client> clientExist = repository.findClientByIdentification(clientRequestDTO.getIdentification());
        if (clientExist.isPresent()) {
            throw new IllegalStateException("Client with identification " + clientRequestDTO.getIdentification() + " already exists");
        }
        Client client = mapper.toEntity(clientRequestDTO);
        Client savedCliente = repository.save(client);
        clientCreateProducer.sendClientCreateMessage(savedCliente.getId(), savedCliente.getIdentification());
        return mapper.toDTO(savedCliente);
    }

    @Override
    public ClientResponseDTO findById(Long id) {
        return repository.findById(id).map(mapper::toDTO).orElseThrow(() -> new IllegalStateException("Client not found"));
    }

    @Override
    public List<ClientResponseDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    @Override
    public ClientResponseDTO update(Long id, ClientUpdateDTO clientUpdateDTO) {
        Client client = repository.findById(id).orElseThrow(() -> new IllegalStateException("Client not found"));
        mapper.toEntityUpdate(clientUpdateDTO, client);
        Client savedClient = repository.save(client);
        return mapper.toDTO(savedClient);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    @CircuitBreaker(name = "customerService", fallbackMethod = "fallBackForCustomerDataClient")
    public String getCustomDataClient(Long id) {
        throw new RuntimeException("Simulating failure");
    }

    private String fallBackForCustomerDataClient(Long id, Throwable ex) {
        return "Fallback response for client: " + id;
    }
}
