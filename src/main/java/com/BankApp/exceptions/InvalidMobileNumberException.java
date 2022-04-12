package com.BankApp.exceptions;

public class InvalidMobileNumberException extends RuntimeException {

    public InvalidMobileNumberException(String message) {
        super(message);
    }
}
