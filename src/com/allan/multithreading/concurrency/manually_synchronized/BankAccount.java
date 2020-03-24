package com.allan.multithreading.concurrency.manually_synchronized;

public class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void deposit(int amount){
        balance += amount;
    }

    public synchronized void withdrawal(int amount){
        balance -= amount;
    }
}
