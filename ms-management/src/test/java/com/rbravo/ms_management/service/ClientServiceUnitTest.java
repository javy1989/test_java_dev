package com.rbravo.ms_management.service;

import com.rbravo.ms_management.model.dto.ClientDTO;
import com.rbravo.ms_management.model.entity.Client;
import com.rbravo.ms_management.model.mapper.IClientMapper;
import com.rbravo.ms_management.model.repository.IClientRepository;
import com.rbravo.ms_management.model.service.impl.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Unit tests for ClientService with DTOs, using Mockito for in-memory testing.
 */
@ExtendWith(MockitoExtension.class)
class ClientServiceUnitTest {

    @Mock
    private IClientRepository clientRepository;

    @Mock
    private IClientMapper clientMapper;

    @InjectMocks
    private ClientService clientService;

    @BeforeEach
    void setup() {

    }

    @Test
    void should_SaveAndRetrieveClient_When_ValidClientDTOProvided() {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setName("Ricardo Bravo");
        clientDTO.setPassword("pwd");
        clientDTO.setStatus(true);

        Client client = new Client();
        client.setId(1L);
        client.setName("Ricardo Bravo");
        client.setPassword("pwd");
        client.setStatus(true);

        when(clientMapper.toEntity(clientDTO)).thenReturn(client);
        when(clientRepository.save(client)).thenReturn(client);
        when(clientMapper.toDTO(client)).thenReturn(clientDTO);

        ClientDTO savedClientDTO = clientService.create(clientDTO);

        assertNotNull(savedClientDTO);
        assertEquals("Ricardo Bravo", savedClientDTO.getName());
        verify(clientRepository, times(1)).save(client);
    }
}
