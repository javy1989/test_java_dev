package com.rbravo.ms_account.controller.rest;


import com.rbravo.ms_account.model.dto.AccountDTO;
import com.rbravo.ms_account.service.IAccountService;
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
 * Represent controller api rest account
 */
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final IAccountService accountService;

    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * Create a new account.
     *
     * @param client the ClientDTO to create.
     * @return the created ClientDTO.
     */
    @PostMapping
    public ResponseEntity<AccountDTO> createClient(@Valid @RequestBody AccountDTO client) {
        return ResponseEntity.status(201).body(accountService.create(client));
    }

    /**
     * Get a Client by ID.
     *
     * @param accountId the ID of the Account.
     * @return the AccountDTO if found.
     */
    @GetMapping("/{accountId}")
    public ResponseEntity<AccountDTO> getClientById(@PathVariable String accountId) {
        return ResponseEntity.ok(accountService.findById(accountId));
    }

    /**
     * Get all accounts.
     *
     * @return a list of all AccountDTO.
     */
    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAll() {
        return ResponseEntity.ok(accountService.findAll());
    }

    /**
     * Update  Account partially.
     *
     * @param accountId the ID of the Client to update.
     * @param payload   the fields to update.
     * @return the updated AccountDTO.
     */
    @PutMapping("/{accountId}")
    public ResponseEntity<AccountDTO> update(@PathVariable String accountId, @Valid @RequestBody AccountDTO payload) {
        return ResponseEntity.ok(accountService.update(accountId, payload));
    }

    /**
     * Delete  Account by ID.
     *
     * @param accountId the ID of the Client to delete.
     */
    @DeleteMapping("/{accountId}")
    public void delete(@PathVariable String accountId) {
        accountService.delete(accountId);
    }
}
