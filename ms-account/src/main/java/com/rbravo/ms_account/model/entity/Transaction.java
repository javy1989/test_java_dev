package com.rbravo.ms_account.model.entity;

import com.rbravo.ms_account.model.enums.TransactionTypeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Represent transaction in the account
 *
 * @author rbravo
 */
@Entity
@Table(
        name = "transactions",
        schema = "transaction",
        indexes = {
                @Index(name = "transaction_account_number_idx", columnList = "account_number"),
                @Index(name = "transaction_date_idx", columnList = "date"),
        }
)
public class Transaction {

    /**
     * The id transaction
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The date generate transaction
     */
    @Column
    private LocalDateTime date;

    /**
     * The type transaction
     */
    @Column(name = "transaction_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionTypeEnum transactionType;

    /**
     * The value of the transaction
     */
    @Column
    private BigDecimal amount;

    /**
     * The value of the transaction
     */
    @Column
    private BigDecimal balance;

    /**
     * The observation of the transaction
     */
    @Column(length = 50)
    private String observation;

    /**
     * The account of the transaction
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_number", nullable = false)
    private Account account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public TransactionTypeEnum getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionTypeEnum transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
