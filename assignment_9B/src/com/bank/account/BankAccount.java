package com.bank.account;

public class BankAccount implements BankOperations {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited: " + amount + ", Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " Invalid deposit amount: " + amount);
        }
    }

    public synchronized void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew: " + amount + ", Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " Invalid withdrawal amount or insufficient balance.");
        }
    }

    @Override
    public synchronized double getBalance() {
        return balance;
    }
}
