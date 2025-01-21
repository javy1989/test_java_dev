package com.rbravo.ms_account.service;

import com.rbravo.ms_account.model.dto.TransactionDTO;

import java.util.List;

/**
 * Represent transaction service
 *
 * @author rbravo
 */
public interface ITransactionService {

    TransactionDTO create(TransactionDTO transaction);

    TransactionDTO findById(Long id);

    List<TransactionDTO> findAll();

    List<TransactionDTO> findByAccountId(Long accountId);

}
