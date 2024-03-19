package com.learn.model;

import java.time.LocalDate;
import java.util.List;

import com.learn.exceptions.InsufficientBalanceException;

/*
 * Create a sub class SBAccount which extends Account class with the following fields:
 * minBalance as double
 * and a method withdraw which deducts the amount from the balance and adds a debit transaction to the list of transactions
 * and throws InsufficientBalanceException if the amount is not available in the account
 */

public class SBAccount extends Account {
    private double minBalance;

    // constructor with one argument
    public SBAccount(int accountNumber, LocalDate openingDate, double minBalance, double balance, List<Transaction> transactions) {
        super(accountNumber, balance, openingDate, transactions);
        this.minBalance = minBalance;
    }

    //getters and setters
    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    //tostring method
    @Override
    public String toString() {
        return "SBAccount [accountNumber=" + this.getAccountNumber() +
        ", opening date=" + this.getOpeningDate() +
        ", balance=" + this.getBalance() +
        ", minBalance=" + minBalance + 
        "]";
    }
    

    //withdraw method
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (getBalance() - amount < minBalance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        Transaction transaction = new Transaction.Builder()
                .date(LocalDate.now())
                .type(Transaction.Type.DEBIT)
                .amount(amount)
                .build();
        super.getTransactions().add(transaction);
        super.setBalance(getBalance() - amount);
    }
}

    
