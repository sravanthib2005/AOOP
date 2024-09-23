package com.bank.account;

public class BankSystemMain {
    public static void main(String[] args) {
        // Create a shared BankAccount with an initial balance
        BankAccount account = new BankAccount(1000.0);

        // Create multiple user transactions
        Thread user1 = new Thread(new UserTransaction(account, true, 500), "User1");  // Deposit 500
        Thread user2 = new Thread(new UserTransaction(account, false, 300), "User2"); // Withdraw 300
        Thread user3 = new Thread(new UserTransaction(account, true, 200), "User3");  // Deposit 200
        Thread user4 = new Thread(new UserTransaction(account, false, 700), "User4"); // Withdraw 700

        // Start the transactions
        user1.start();
        user2.start();
        user3.start();
        user4.start();

        // Wait for all threads to finish
        try {
            user1.join();
            user2.join();
            user3.join();
            user4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the final account balance
        System.out.println("Final Account Balance: " + account.getBalance());
    }
}
