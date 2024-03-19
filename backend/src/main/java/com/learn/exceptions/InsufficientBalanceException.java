package com.learn.exceptions;

// Create exception class InsufficientBalanceException
public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
