package com.rbravo.ms_management.model.service.impl;

import com.rbravo.ms_management.model.dto.ClientDTO;
import com.rbravo.ms_management.model.dto.ClientUpdateDTO;
import com.rbravo.ms_management.model.entity.Client;
import com.rbravo.ms_management.model.mapper.IClientMapper;
import com.rbravo.ms_management.model.mapper.IClientUpdateMapper;
import com.rbravo.ms_management.model.mapper.IGenericMapper;
import com.rbravo.ms_management.model.repository.IClientRepository;
import com.rbravo.ms_management.model.repository.IGenericRepository;
import com.rbravo.ms_management.model.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends CrudService<Client, ClientDTO, Long> implements IClientService {

    private final IClientRepository clientRepository;
    private final IClientMapper clientMapper;
    private final IClientUpdateMapper clientUpdateMapper;

    @Autowired
    public ClientService(IClientRepository clientRepository, IClientMapper clientMapper, IClientUpdateMapper clientUpdateMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
        this.clientUpdateMapper = clientUpdateMapper;
    }

    @Override
    protected IGenericRepository<Client, Long> getRepo() {
        return clientRepository;
    }

    @Override
    protected IGenericMapper<Client, ClientDTO> getMapper() {
        return clientMapper;
    }

    @Override
    public ClientDTO create(ClientDTO clientDTO) {
        if (clientRepository.findClientByIdentification(clientDTO.getIdentification()).isPresent()) {
            throw new IllegalStateException("The Person is already registered with identification");
        }
        clientDTO.setPassword(BCrypt.hashpw(clientDTO.getPassword(), BCrypt.gensalt()));
        return super.save(clientDTO);
    }

    @Override
    public ClientDTO update(Long id, ClientUpdateDTO clientDTO) {
        Client client = getMapper().toEntity(findByid(id));
        clientUpdateMapper.updateClientFromDTO(clientDTO, client);
        client.setId(id);
        Client updatedClient = clientRepository.save(client);
        return clientMapper.toDTO(updatedClient);
    }
}
