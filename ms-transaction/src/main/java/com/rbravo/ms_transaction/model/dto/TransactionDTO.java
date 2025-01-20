package com.rbravo.ms_transaction.model.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;

public class TransactionDTO {

    private Long id;

    @NotNull(message = "Account ID is mandatory")
    private Long accountId;

    @NotBlank(message = "Transaction type is mandatory")
    @Pattern(regexp = "^(WITHDRAWAL|DEPOSIT|)$", message = "Gender must be WITHDRAWAL, DEPOSIT")
    private String transactionType;

    @NotNull(message = "Value is mandatory")
    @DecimalMin(value = "0.01", inclusive = true, message = "Transaction value must be greater than 0")
    private BigDecimal value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
