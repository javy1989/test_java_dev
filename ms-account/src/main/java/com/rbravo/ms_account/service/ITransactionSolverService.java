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

    /**
     * Solve type transaction
     *
     * @param account the account
     * @param type    the type
     * @param amount  the amount
     * @return to {@link Transaction}
     */
    Transaction solve(Account account, TransactionTypeEnum type, BigDecimal amount);

}
