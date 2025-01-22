package com.rbravo.ms_account.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;

/**
 * Data Transfer Object for transaction.
 *
 * @author rbravo
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionDTO {

    private Long id;

    @NotNull(message = "Account ID is mandatory")
    private String accountNumber;

    @NotBlank(message = "Transaction type is mandatory")
    @Pattern(regexp = "^(WITHDRAWAL|DEPOSIT|)$", message = "Gender must be WITHDRAWAL, DEPOSIT")
    private String transactionType;

    @NotNull(message = "Amount is mandatory")
    @DecimalMin(value = "0.01", inclusive = true, message = "Transaction value must be greater than 0")
    private BigDecimal amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
