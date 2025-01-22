package com.rbravo.ms_customer.repository;

import com.rbravo.ms_customer.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for the Person entity.
 *
 * @author rbravo
 */
public interface IPersonRepository extends JpaRepository<Person, Long> {
}
