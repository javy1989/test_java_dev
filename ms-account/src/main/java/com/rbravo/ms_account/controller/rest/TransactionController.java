package com.rbravo.ms_account.controller.rest;

import com.rbravo.ms_account.model.dto.TransactionDTO;
import com.rbravo.ms_account.service.ITransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Represent controller api rest transaction
 */
@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    @Autowired
    private ITransactionService transactionService;

    /**
     * Create a new transaction.
     *
     * @param transaction the TransactionDTO to create.
     * @return the created TransactionDTO.
     */
    @PostMapping
    public ResponseEntity<TransactionDTO> create(@Valid @RequestBody TransactionDTO transaction) {
        return ResponseEntity.status(201).body(transactionService.create(transaction));
    }
}
