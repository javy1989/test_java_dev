package com.rbravo.ms_account.exception;

/**
 * Represents the error of an account without funds
 *
 * @author rbravo
 */
public class InsufficientBalanceException extends RuntimeException {

    public InsufficientBalanceException(String message) {
        super(message);
    }

}
