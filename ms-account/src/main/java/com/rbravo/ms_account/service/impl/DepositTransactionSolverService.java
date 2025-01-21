package com.rbravo.ms_account.service.impl;

import com.rbravo.ms_account.model.entity.Account;
import com.rbravo.ms_account.model.entity.Transaction;
import com.rbravo.ms_account.model.enums.TransactionTypeEnum;
import com.rbravo.ms_account.repository.IAccountRepository;
import com.rbravo.ms_account.repository.ITransactionRepository;
import com.rbravo.ms_account.service.IGeneratorTransactionService;
import com.rbravo.ms_account.service.IProcessorTransactionSolverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class DepositTransactionSolverService implements IProcessorTransactionSolverService {

    private final ITransactionRepository transactionRepository;
    private final IAccountRepository accountRepository;
    private final IGeneratorTransactionService generatorTransactionService;

    @Autowired
    public DepositTransactionSolverService(ITransactionRepository transactionRepository,
                                           IAccountRepository accountRepository,
                                           IGeneratorTransactionService generatorTransactionService) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.generatorTransactionService = generatorTransactionService;
    }

    @Override
    @Transactional
    public Transaction solve(Account account, BigDecimal amount) {
        account.setBalance(account.getBalance().add(amount));
        accountRepository.save(account);
        return generatorTransactionService.generateTransaction(account, TransactionTypeEnum.DEPOSIT, amount, account.getBalance());
    }
}
