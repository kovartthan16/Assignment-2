package com.learn.model;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;

/*
 * Create a sub class FDAccount which extends Account class with the following fields:
 * maturityDate as LocalDate
 * interestRate as double
 * and create below methods
 * getTenure - to return the tenure of the FD in months
 * getMaturityAmount - to return the  maturity amount of the FD
 */
public class FDAccount extends Account {
    private LocalDate maturityDate;
    private double interestRate;

    // constructor with one argument
    public FDAccount(int accountNumber, LocalDate openingDate, LocalDate maturityDate, double interestRate, double balance, List<Transaction> transactions) {
        super(accountNumber, balance, openingDate, transactions);
        this.maturityDate = maturityDate;
        this.interestRate = interestRate;
    }

    // tostring method
    @Override
    public String toString() {
        return "FDAccount [accountNumber=" + this.getAccountNumber() +
        ", opening date=" + this.getOpeningDate() +
        ", balance=" + this.getBalance() +
        ", maturityDate=" + maturityDate +
        ", interestRate=" + interestRate + 
        ", maturity Amount=" + this.getMaturityAmount() + 
        "]";
    }

    //Create a methog genTenure to get the tenure of the FD in months
    public int getTenure() {
        return (int) (this.maturityDate.atStartOfDay().toEpochSecond(ZoneOffset.UTC) - getOpeningDate().atStartOfDay().toEpochSecond(ZoneOffset.UTC)) / (60 * 60 * 24 * 30);
    }    

    public double getMaturityAmount() {
        return getBalance() + (getBalance() * interestRate * getTenure() / 100) * maturityDate.getDayOfMonth() / 365;
    }
}
