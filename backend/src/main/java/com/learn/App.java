package com.learn;

import java.time.LocalDate;
import java.util.ArrayList;

import com.learn.exceptions.InsufficientBalanceException;
import com.learn.model.FDAccount;
import com.learn.model.SBAccount;
import com.learn.model.Transaction;

public class App 
{
    public static void main( String[] args ) throws InsufficientBalanceException
    {
        System.out.println( "Creating FD Account");
        FDAccount fdAccount = new FDAccount(100, LocalDate.now(), LocalDate.now().plusMonths(12),
        5.0, 10000, new ArrayList<Transaction>());
        System.out.println( "FD Account Details");
        System.out.println(fdAccount.toString());

        System.out.println( "Creating SB Account");
        SBAccount sbAccount = new SBAccount(101, LocalDate.now(), 1000, 10000, new ArrayList<Transaction>());        
        System.out.println( "SB Account Details");
        System.out.println(sbAccount.toString());

        System.out.println("Depositing 1500 to SB Account");
        sbAccount.deposit(1500);
        System.out.println(sbAccount.toString());
        System.out.println("Withdrawing 500 from the SB Account");
        sbAccount.withdraw(500);
        System.out.println(sbAccount.toString());
        System.out.println("Withdrawing 11000 from the SB Account");
        try {
            sbAccount.withdraw(11000);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(sbAccount.toString());
        System.out.println("Transactions List");
        System.out.println(sbAccount.getTransactions());
    }
}
