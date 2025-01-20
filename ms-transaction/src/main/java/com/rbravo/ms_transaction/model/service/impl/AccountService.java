package com.rbravo.ms_transaction.model.service.impl;

import com.rbravo.ms_transaction.model.dto.AccountDTO;
import com.rbravo.ms_transaction.model.entity.Account;
import com.rbravo.ms_transaction.model.mapper.IAccountMapper;
import com.rbravo.ms_transaction.model.mapper.IGenericMapper;
import com.rbravo.ms_transaction.model.repository.IAccountRepository;
import com.rbravo.ms_transaction.model.repository.IGenericRepository;
import com.rbravo.ms_transaction.model.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends CrudService<Account, AccountDTO, String> implements IAccountService {

    private final IAccountRepository accountRepository;
    private final IAccountMapper accountMapper;

    @Autowired
    public AccountService(IAccountRepository accountRepository, IAccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    protected IGenericRepository<Account, String> getRepo() {
        return accountRepository;
    }

    @Override
    protected IGenericMapper<Account, AccountDTO> getMapper() {
        return accountMapper;
    }
}
