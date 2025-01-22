package com.rbravo.ms_account.controller.rest;

import com.rbravo.ms_account.model.dto.TransactionDTO;
import com.rbravo.ms_account.service.ITransactionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Represent controller api rest transaction
 */
@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    private final ITransactionService transactionService;

    public TransactionController(ITransactionService transactionService) {
        this.transactionService = transactionService;
    }

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

    /**
     * Get a Transaction by ID.
     *
     * @param transactionId the ID of the transaction.
     * @return the TransactionDTO if found.
     */
    @GetMapping("/{transactionId}")
    public ResponseEntity<TransactionDTO> getTransactionById(@PathVariable Long transactionId) {
        return ResponseEntity.ok(transactionService.findById(transactionId));
    }

    /**
     * Get all Transactions.
     *
     * @return a list of all TransactionDTOs.
     */
    @GetMapping
    public List<TransactionDTO> getAll() {
        return transactionService.findAll();
    }

    /**
     * Update a Transaction partially.
     *
     * @param transactionId the ID of the Transaction to update.
     * @param payload       the fields to update.
     * @return the updated TransactionDTO.
     */
    @PutMapping("/{transactionId}")
    public ResponseEntity<TransactionDTO> update(@PathVariable Long transactionId, @Valid @RequestBody TransactionDTO payload) {
        return ResponseEntity.ok(transactionService.update(transactionId, payload));
    }

    /**
     * Delete a Transaction by ID.
     *
     * @param transactionId the ID of the Transaction to delete.
     */
    @DeleteMapping("/{transactionId}")
    public void delete(@PathVariable Long transactionId) {
        transactionService.delete(transactionId);
    }
}

