package com.rbravo.ms_account.service;

import com.rbravo.ms_account.model.entity.Account;
import com.rbravo.ms_account.model.entity.Transaction;

import java.math.BigDecimal;

/**
 * Represent processor solver transaction
 */
public interface IProcessorTransactionSolverService {

    Transaction solve(Account account, BigDecimal value);

}
