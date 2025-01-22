package com.rbravo.ms_account.exception;

/**
 * Represents the error of an account not found
 *
 * @author rbravo
 */
public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(String message) {
        super(message);
    }

}
