package com.rbravo.ms_account.service;

import com.rbravo.ms_account.model.dto.AccountDTO;

import java.util.List;

/**
 * Represent service account
 *
 * @author rbravo
 */
public interface IAccountService {

    /**
     * Create a account
     *
     * @param account the payload account
     * @return to  {@link AccountDTO}
     */
    AccountDTO create(AccountDTO account);

    /**
     * Search account by account number
     *
     * @param accountNumber the account number
     * @return to {@link AccountDTO}
     */
    AccountDTO findById(String accountNumber);

    /**
     * Search all account
     *
     * @return to {@link List<AccountDTO>}
     */
    List<AccountDTO> findAll();

    /**
     * Update information account
     *
     * @param accountNumber the accountNumber of account
     * @param account       the account
     * @return to {@link AccountDTO}
     */
    AccountDTO update(String accountNumber, AccountDTO account);

    /**
     * Delete account
     *
     * @param accountNumber the account number
     */
    void delete(String accountNumber);
}
