package com.rbravo.ms_transaction.model.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;

/**
 * Data Transfer Object for Account.
 *
 * @author rbravo
 */
public class AccountDTO {

    private Long id;

    @NotBlank(message = "Account number is mandatory")
    private String accountNumber;

    @NotBlank(message = "Account type is mandatory")
    @Pattern(regexp = "^(SAVINGS|CURRENT)$", message = "Gender must be SAVINGS, CURRENT")
    private String type;

    @NotNull(message = "Initial balance is mandatory")
    @DecimalMin(value = "0.0", inclusive = true, message = "Initial balance must be non-negative")
    private BigDecimal initialBalance;

    @NotNull(message = "Status is mandatory")
    private Boolean status;

    @NotNull(message = "Client ID is mandatory")
    private Long clientId;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(BigDecimal initialBalance) {
        this.initialBalance = initialBalance;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
