package com.learn.model;

import java.time.LocalDate;
import java.util.List;

/*
 * Create an abstract class Account with the following fields:
 * accountNumber as integer
 * balance as double
 * openingDate as java LocalDate object
 * list of transactions as List of Transaction objects
 * 
 * Create below methods in the Account class:
 * deposit method to add credit transaction to the list of transactions for each deposit
 * getAccountDetails method which returns a string with account details
 */
public abstract class Account {
    private int accountNumber;
    private double balance;
    private LocalDate openingDate;
    private List<Transaction> transactions;

    // constructor with one argument
    public Account(int accountNumber, double balance, LocalDate openingDate, List<Transaction> transactions) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.openingDate = openingDate;
        this.transactions = transactions;
    }

    //getters and setters
    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }


    public void deposit(double amount) {
        Transaction transaction = new Transaction.Builder()
                .date(LocalDate.now())
                .type(Transaction.Type.CREDIT)
                .amount(amount)
                .build();
        transactions.add(transaction);
        balance += amount;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    // tostring method
    @Override
    public String toString() {
        return "Account [accountNumber=" + accountNumber + ", balance=" + balance + ", openingDate=" + openingDate
                + ", transactions=" + transactions + "]";
    }   
}
