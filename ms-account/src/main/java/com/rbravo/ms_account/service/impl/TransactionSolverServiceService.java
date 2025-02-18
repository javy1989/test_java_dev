package com.rbravo.ms_account.service.impl;

import com.rbravo.ms_account.model.entity.Account;
import com.rbravo.ms_account.model.entity.Transaction;
import com.rbravo.ms_account.model.enums.TransactionTypeEnum;
import com.rbravo.ms_account.service.IProcessorTransactionSolverService;
import com.rbravo.ms_account.service.ITransactionSolverService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Class to resolve the type of transaction being processed
 *
 * @author rbravo
 */
@Service
public class TransactionSolverServiceService implements ITransactionSolverService {

    private final DepositTransactionSolverService depositSolver;
    private final WithdrawalTransactionSolverService withdrawalTransactionSolver;

    public TransactionSolverServiceService(DepositTransactionSolverService depositSolver,
                                           WithdrawalTransactionSolverService withdrawalTransactionSolver) {
        this.depositSolver = depositSolver;
        this.withdrawalTransactionSolver = withdrawalTransactionSolver;
    }

    private IProcessorTransactionSolverService filterTypeTransaction(TransactionTypeEnum type) {
        return switch (type) {
            case DEPOSIT -> depositSolver;
            case WITHDRAWAL -> withdrawalTransactionSolver;
            default -> throw new IllegalArgumentException("Unsupported transaction type");
        };
    }

    @Override
    public Transaction solve(Account account, TransactionTypeEnum type, BigDecimal value) {
        IProcessorTransactionSolverService solver = filterTypeTransaction(type);
        return solver.solve(account, value);
    }
}
