package com.rbravo.ms_management.model.repository;

import com.rbravo.ms_management.model.entity.Client;

import java.util.Optional;


/**
 * Repository for the Client entity.
 *
 * @author rbravo
 */
public interface IClientRepository extends IGenericRepository<Client, Long> {

    /**
     * Find a Client by the associated Person identifier.
     *
     * @param identification the identifier of the Person.
     * @return an Optional containing the Client if found.
     */
    Optional<Client> findClientByIdentification(String identification);
}
