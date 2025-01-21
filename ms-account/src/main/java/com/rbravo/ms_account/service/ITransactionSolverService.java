package com.rbravo.ms_account.service;

import com.rbravo.ms_account.model.entity.Account;
import com.rbravo.ms_account.model.entity.Transaction;
import com.rbravo.ms_account.model.enums.TransactionTypeEnum;

import java.math.BigDecimal;

/**
 * Represent solve type transaction
 *
 * @author rbravo
 */
public interface ITransactionSolverService {

    Transaction solve(Account account, TransactionTypeEnum type, BigDecimal amount);

}
