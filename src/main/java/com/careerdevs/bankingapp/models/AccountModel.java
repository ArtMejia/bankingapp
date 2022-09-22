package com.careerdevs.bankingapp.models;

import javax.persistence.*;

@Entity
@Table(name="accounts")
public class AccountModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String accountNumber;

    public static class CheckingAccount {
        private double balance;
        private double transFee;

        public double getBalance() {
            return balance;
        }

        public double getTransFee() {
            return transFee;
        }
    }

    public static class SavingsAccount {
        private double balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
