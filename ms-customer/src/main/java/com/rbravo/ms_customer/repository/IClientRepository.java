package com.rbravo.ms_customer.repository;

import com.rbravo.ms_customer.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository for the Client entity.
 *
 * @author rbravo
 */
public interface IClientRepository extends JpaRepository<Client, Long> {

    /**
     * Find a Client by the associated Person identifier.
     *
     * @param identification the identifier of the Person.
     * @return an Optional containing the Client if found.
     */
    Optional<Client> findClientByIdentification(String identification);
}
