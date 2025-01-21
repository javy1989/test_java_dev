package com.rbravo.ms_account.service;

import com.rbravo.ms_account.model.dto.AccountDTO;
import com.rbravo.ms_account.model.dto.ClientEvent;

import java.util.List;

/**
 * Represent service account
 *
 * @author rbravo
 */
public interface IAccountService {

    AccountDTO create(AccountDTO account);

    AccountDTO findById(String accountNumber);

    List<AccountDTO> findAll();

    AccountDTO update(Long id, AccountDTO account);

    void delete(String accountNumber);

    void createEvent(ClientEvent clientEvent);
}
