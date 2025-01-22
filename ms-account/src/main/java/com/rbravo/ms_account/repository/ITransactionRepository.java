package com.rbravo.ms_account.repository;

import com.rbravo.ms_account.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Represents repository transaction
 *
 * @author rbravo
 */
public interface ITransactionRepository extends JpaRepository<Transaction, Long> {

}
