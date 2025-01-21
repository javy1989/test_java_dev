package com.rbravo.ms_customer.service.impl;

import com.rbravo.ms_customer.mapper.ClientMapper;
import com.rbravo.ms_customer.model.dto.ClientEvent;
import com.rbravo.ms_customer.model.dto.ClientRequestDTO;
import com.rbravo.ms_customer.model.dto.ClientResponseDTO;
import com.rbravo.ms_customer.model.dto.ClientUpdateDTO;
import com.rbravo.ms_customer.model.entity.Client;
import com.rbravo.ms_customer.repository.IClientRepository;
import com.rbravo.ms_customer.service.IClientService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService {

    @Value("${app.rabbit.client.exchange}")
    private String clientExchange;

    @Value("${app.rabbit.client.created-routing-key}")
    private String clientCreatedRoutingKey;

    private final IClientRepository repository;
    private final ClientMapper mapper;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ClientService(IClientRepository repository, ClientMapper mapper, RabbitTemplate rabbitTemplate) {
        this.repository = repository;
        this.mapper = mapper;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public ClientResponseDTO create(ClientRequestDTO clientRequestDTO) {
        Optional<Client> clientExist = repository.findClientByIdentification(clientRequestDTO.getIdentification());
        if (clientExist.isPresent()) {
            throw new IllegalStateException("Client with identification " + clientRequestDTO.getIdentification() + " already exists");
        }
        Client client = mapper.toEntity(clientRequestDTO);
        Client savedCliente = repository.save(client);
        ClientEvent event = new ClientEvent();
        event.setClientId(savedCliente.getId());
        event.setIdentification(savedCliente.getIdentification());
        rabbitTemplate.convertAndSend(clientExchange, clientCreatedRoutingKey, event);
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
        Client client = mapper.toEntity(findById(id));
        mapper.toEntityUpdate(clientUpdateDTO, client);
        Client savedClient = repository.save(client);
        return mapper.toDTO(savedClient);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }
}
