package com.rbravo.ms_customer.model;

import com.rbravo.ms_customer.model.entity.Client;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for the Client entity.
 */

@ExtendWith(MockitoExtension.class)
class ClientEntityTest {

    @Test
    void should_CreateClient_When_AllFieldsAreValid() {
        Client client = new Client();
        client.setId(1L);
        client.setName("Ricardo Bravo");
        client.setPassword("pwd");
        client.setStatus(true);
        client.setAddress("Tumbaco");
        client.setPhone("0000-00");


        assertEquals(1L, client.getId());
        assertEquals("Ricardo Bravo", client.getName());
        assertEquals("pwd", client.getPassword());
        assertTrue(client.isStatus());
        assertEquals("Tumbaco", client.getAddress());
        assertEquals("0000-00", client.getPhone());
    }

    @Test
    void should_FailValidation_When_NameIsNull() {
        Client client = new Client();
        client.setId(2L);
        client.setName(null);

        String name = client.getName();

        assertNull(name, "Name should be null");
    }

    @Test
    void should_FailValidation_When_ActiveIsFalse() {

        Client client = new Client();
        client.setId(3L);
        client.setStatus(false);

        boolean isActive = client.isStatus();

        assertFalse(isActive, "Client should not be active");
    }

    @Test
    void should_HandleEmptyPassword_When_SetToEmptyString() {
        Client client = new Client();
        client.setId(4L);
        client.setPassword("");

        String password = client.getPassword();

        assertEquals("", password, "Password should be an empty string");
    }

    @Test
    void should_HandleLongAddress_When_ExceedsNormalLength() {
        Client client = new Client();
        String longAddress = "123 Main Street, Apartment 45, Springfield, State, Country, 12345-6789";
        client.setAddress(longAddress);

        String address = client.getAddress();

        assertEquals(longAddress, address, "Address should match the long input string");
    }
}

