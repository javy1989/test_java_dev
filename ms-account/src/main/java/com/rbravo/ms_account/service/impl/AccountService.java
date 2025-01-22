package com.rbravo.ms_account.service.impl;

import com.rbravo.ms_account.exception.AccountNotFoundException;
import com.rbravo.ms_account.mapper.AccountMapper;
import com.rbravo.ms_account.model.dto.AccountDTO;
import com.rbravo.ms_account.model.entity.Account;
import com.rbravo.ms_account.repository.IAccountRepository;
import com.rbravo.ms_account.service.IAccountService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class service to account
 *
 * @author rbravo
 */
@Service
public class AccountService implements IAccountService {


    private final IAccountRepository repository;
    private final AccountMapper accountMapper;

    public AccountService(IAccountRepository repository, AccountMapper accountMapper) {
        this.repository = repository;
        this.accountMapper = accountMapper;
    }

    @Override
    public AccountDTO create(AccountDTO accountDTO) {
        Account account = accountMapper.toEntity(accountDTO);
        account.generateAccountNumber();
        account.setBalance(account.getInitialBalance());
        Account savedAccount = repository.save(account);
        return accountMapper.toDTO(savedAccount);
    }

    @Override
    public AccountDTO findById(String accountNumber) {
        return repository.findById(accountNumber).map(accountMapper::toDTO)
                .orElseThrow(() -> new AccountNotFoundException("Account not found"));
    }

    @Override
    public List<AccountDTO> findAll() {
        return repository.findAll().stream().map(accountMapper::toDTO).toList();
    }

    @Override
    public AccountDTO update(String number, AccountDTO accountDTo) {
        Account account = repository.findById(number).orElseThrow(() -> new AccountNotFoundException("Account not found"));
        accountMapper.toEntityUpdate(accountDTo, account);
        Account savedAccount = repository.save(account);
        return accountMapper.toDTO(savedAccount);
    }

    @Override
    public void delete(String accountNumber) {
        findById(accountNumber);
        repository.deleteById(accountNumber);
    }
}
