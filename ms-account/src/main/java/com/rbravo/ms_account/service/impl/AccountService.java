package com.rbravo.ms_account.service.impl;

import com.rbravo.ms_account.exception.AccountNotFoundException;
import com.rbravo.ms_account.mapper.AccountMapper;
import com.rbravo.ms_account.model.dto.AccountDTO;
import com.rbravo.ms_account.model.dto.ClientEvent;
import com.rbravo.ms_account.model.entity.Account;
import com.rbravo.ms_account.model.enums.AccountTypeEnum;
import com.rbravo.ms_account.repository.IAccountRepository;
import com.rbravo.ms_account.service.IAccountService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AccountService implements IAccountService {

    private static final Logger log = LoggerFactory.getLogger(AccountService.class);


    private final IAccountRepository repository;
    private final AccountMapper accountMapper;

    @Autowired
    public AccountService(IAccountRepository repository, AccountMapper accountMapper) {
        this.repository = repository;
        this.accountMapper = accountMapper;
    }

    @Override
    public AccountDTO create(AccountDTO accountDTO) {
        Account account = accountMapper.toEntity(accountDTO);
        String numberAccount = String.format("%06d", new Random().nextInt(1000000));
        account.setAccountNumber(numberAccount);
        Account savedAccount = repository.save(account);
        return accountMapper.toDTO(savedAccount);
    }

    @Override
    public AccountDTO findById(String accountNumber) {
        return repository.findById(accountNumber).map(accountMapper::toDTO).orElseThrow(() -> new AccountNotFoundException("Account not found"));
    }

    @Override
    public List<AccountDTO> findAll() {
        return repository.findAll().stream().map(accountMapper::toDTO).toList();
    }

    @Override
    public AccountDTO update(Long id, AccountDTO account) {
        return null;
    }

    @Override
    public void delete(String accountNumber) {
        findById(accountNumber);
        repository.deleteById(accountNumber);
    }


    @Override
    @RabbitListener(queues = "${app.rabbit.client.created-queue}")
    public void createEvent(ClientEvent clientEvent) {
        log.info("Reception create account client event: {}", clientEvent);
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setClientId(clientEvent.getClientId());
        accountDTO.setStatus(true);
        accountDTO.setBalance(BigDecimal.ZERO);
        accountDTO.setAccountType(AccountTypeEnum.SAVINGS);
        this.create(accountDTO);
    }
}
