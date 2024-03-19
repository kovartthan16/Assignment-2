package com.learn.model;

import java.time.LocalDate;

/*
 * Create Transaction class with the following fields:
 * date as java LocalDate object
 * type as enum with 'debit' and 'credit'
 * amount as double
 * create a builder class for the Transaction class to create Transaction objects
 */
public class Transaction {


    public enum Type {
        DEBIT, CREDIT
    }

    private LocalDate date;
    private Type type;
    private double amount;

    private Transaction(Builder builder) {
        this.date = builder.date;
        this.type = builder.type;
        this.amount = builder.amount;
    }

    //getters and setters
    public LocalDate getDate() {
        return date;
    }

    public Type getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    //setters
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    //tostring method
    @Override
    public String toString() {
        return "Transaction [date=" + date + ", type=" + type + ", amount=" + amount + "]";
    }    

    public static class Builder {
        private LocalDate date;
        private Type type;
        private double amount;

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder type(Type type) {
            this.type = type;
            return this;
        }

        public Builder amount(double amount) {
            this.amount = amount;
            return this;
        }

        public Transaction build() {
            return new Transaction(this);
        }
    }
}
