package com.rbravo.ms_transaction.model.entity;

import com.rbravo.ms_transaction.model.enums.AccountTypeEnum;
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
    @Column
    @Enumerated(EnumType.STRING)
    private AccountTypeEnum type;

    /**
     * The initial balance of the account
     */
    @Column(name = "initial_balance")
    private BigDecimal initialBalance;

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

    public AccountTypeEnum getType() {
        return type;
    }

    public void setType(AccountTypeEnum type) {
        this.type = type;
    }

    public BigDecimal getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(BigDecimal initialBalance) {
        this.initialBalance = initialBalance;
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
