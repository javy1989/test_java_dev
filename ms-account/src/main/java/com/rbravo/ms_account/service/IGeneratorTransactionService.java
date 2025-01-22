package com.rbravo.ms_account.service;

import com.rbravo.ms_account.model.entity.Account;
import com.rbravo.ms_account.model.entity.Transaction;
import com.rbravo.ms_account.model.enums.TransactionTypeEnum;

import java.math.BigDecimal;

/**
 * Represent generator transaction
 *
 * @author rbravo
 */
public interface IGeneratorTransactionService {

    /**
     * Generate a transaction
     *
     * @param account the account
     * @param type    the type transaction
     * @param amount  the value
     * @param balance the balance
     * @return to {@link Transaction}
     */
    Transaction generateTransaction(Account account, TransactionTypeEnum type, BigDecimal amount, BigDecimal balance);

}
