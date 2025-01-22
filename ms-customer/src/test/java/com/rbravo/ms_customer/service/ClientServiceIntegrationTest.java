package com.rbravo.ms_customer.service;

import com.rbravo.ms_customer.model.dto.ClientUpdateDTO;
import com.rbravo.ms_customer.model.entity.Client;
import com.rbravo.ms_customer.model.enums.GenderTypeEnum;
import com.rbravo.ms_customer.repository.IClientRepository;
import com.rbravo.ms_customer.service.impl.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ActiveProfiles("test")
class ClientServiceIntegrationTest {

    @Autowired
    private IClientRepository clientRepository;

    @Autowired
    private ClientService clientService;

    @Test
    void givenClientWithPassword_whenUpdatedWithNullPassword_thenPasswordIsNotOverwritten() {

        Client initialClient = new Client();
        initialClient.setName("John Perez");
        initialClient.setGender(GenderTypeEnum.M);
        initialClient.setIdentification("12345678");
        initialClient.setAddress("Main Avenue 123");
        initialClient.setPhone("987654321");
        initialClient.setPassword("password123");
        initialClient.setBirthdate(LocalDate.now());
        initialClient.setStatus(true);

        clientRepository.save(initialClient);

        ClientUpdateDTO clientDto = new ClientUpdateDTO();
        clientDto.setName("John Updated");
        clientDto.setAddress("Updated Avenue 456");

        clientService.update(initialClient.getId(), clientDto);

        Client updatedClient = clientRepository.findById(initialClient.getId()).orElseThrow();
        assertEquals("password123", updatedClient.getPassword());
        assertEquals("John Updated", updatedClient.getName());
        assertEquals("Updated Avenue 456", updatedClient.getAddress());
    }
}
