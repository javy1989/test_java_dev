package com.rbravo.ms_account.repository;

import com.rbravo.ms_account.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, String> {
}
