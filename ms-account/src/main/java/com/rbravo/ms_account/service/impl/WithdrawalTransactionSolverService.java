package com.rbravo.ms_account.service.impl;

import com.rbravo.ms_account.exception.InsufficientBalanceException;
import com.rbravo.ms_account.model.entity.Account;
import com.rbravo.ms_account.model.entity.Transaction;
import com.rbravo.ms_account.model.enums.TransactionTypeEnum;
import com.rbravo.ms_account.repository.IAccountRepository;
import com.rbravo.ms_account.service.IGeneratorTransactionService;
import com.rbravo.ms_account.service.IProcessorTransactionSolverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class WithdrawalTransactionSolverService implements IProcessorTransactionSolverService {

    private final IAccountRepository accountRepository;
    private final IGeneratorTransactionService generatorTransactionService;

    @Autowired
    public WithdrawalTransactionSolverService(IAccountRepository accountRepository, IGeneratorTransactionService generatorTransactionService) {
        this.accountRepository = accountRepository;
        this.generatorTransactionService = generatorTransactionService;
    }

    @Override
    @Transactional
    public Transaction solve(Account account, BigDecimal amount) {
        if (account.getBalance().compareTo(amount) < 0) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        account.setBalance(account.getBalance().subtract(amount));
        accountRepository.save(account);
        return generatorTransactionService.generateTransaction(account, TransactionTypeEnum.WITHDRAWAL, amount.negate(), account.getBalance());
    }
}
