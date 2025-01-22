package com.rbravo.ms_account.service;

import com.rbravo.ms_account.model.dto.TransactionDTO;

import java.util.List;

/**
 * Represent transaction service
 *
 * @author rbravo
 */
public interface ITransactionService {

    /**
     * Create transaction
     *
     * @param transaction the payload transaction
     * @return to {@link TransactionDTO}
     */
    TransactionDTO create(TransactionDTO transaction);

    /**
     * Search transaction by id
     *
     * @param id the id transaction
     * @return to {@link TransactionDTO}
     */
    TransactionDTO findById(Long id);

    /**
     * Search all transaction
     *
     * @return to {@link List<TransactionDTO>}
     */
    List<TransactionDTO> findAll();

    /**
     * Update transaction
     *
     * @param transactionDto the transaction
     * @return to {@link TransactionDTO}
     */
    TransactionDTO update(Long id, TransactionDTO transactionDto);

    /**
     * Delete transaction
     *
     * @param transactionId the id
     */
    void delete(Long transactionId);
}
