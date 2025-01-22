package com.rbravo.ms_account.service.impl;

import com.rbravo.ms_account.model.entity.Account;
import com.rbravo.ms_account.model.entity.Transaction;
import com.rbravo.ms_account.model.enums.TransactionTypeEnum;
import com.rbravo.ms_account.repository.ITransactionRepository;
import com.rbravo.ms_account.service.IGeneratorTransactionService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Class generate transaction
 *
 * @author rbravo
 */
@Service
public class GeneratorTransactionService implements IGeneratorTransactionService {

    private final ITransactionRepository transactionRepository;

    public GeneratorTransactionService(ITransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction generateTransaction(Account account, TransactionTypeEnum type, BigDecimal amount, BigDecimal balance) {
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setAccount(account);
        transaction.setBalance(balance);
        transaction.setTransactionType(type);
        transaction.setDate(LocalDateTime.now());
        transaction.setObservation(type.name() + ":" + amount);
        return transactionRepository.save(transaction);
    }
}
