package com.rbravo.ms_account.service;

import com.rbravo.ms_account.model.entity.Account;
import com.rbravo.ms_account.model.entity.Transaction;

import java.math.BigDecimal;

/**
 * Represent processor solver transaction
 */
public interface IProcessorTransactionSolverService {

    /**
     * Resolves the transaction
     *
     * @param account the account
     * @param value   the value
     * @return to {@link Transaction}
     */
    Transaction solve(Account account, BigDecimal value);

}
