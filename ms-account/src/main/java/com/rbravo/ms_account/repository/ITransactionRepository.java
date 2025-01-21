package com.rbravo.ms_account.repository;

import com.rbravo.ms_account.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT t FROM Transaction  as t JOIN FETCH t.account WHERE t.id=?1")
    List<Transaction> findByAccountAndId(Long accountId);
}
