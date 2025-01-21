package com.rbravo.ms_account.model.entity;

import com.rbravo.ms_account.model.enums.AccountTypeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

import java.math.BigDecimal;

/**
 * Represent account of the client
 *
 * @author rbravo
 */
@Entity
@Table(
        name = "accounts",
        schema = "transaction",
        indexes = {
                @Index(name = "account_client_id_idx", columnList = "client_id")
        }
)
public class Account {

    /**
     * The account number of the account
     */
    @Id
    @Column(name = "account_number", nullable = false, length = 20)
    private String accountNumber;

    /**
     * The account type of account
     */
    @Column(name = "account_type")
    @Enumerated(EnumType.STRING)
    private AccountTypeEnum accountType;

    /**
     * The balance of the account
     */
    @Column(name = "balance")
    private BigDecimal balance;
    /**
     * The status of the account
     */
    @Column
    private boolean status;

    /**
     * The client to whom the account belongs
     */
    @Column(name = "client_id", nullable = false)
    private Long clientId;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountTypeEnum getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountTypeEnum accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
