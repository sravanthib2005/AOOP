package com.bank.account;

public interface BankOperations {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
}
