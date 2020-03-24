package com.allan.multithreading.concurrency.synchronized_method;

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
}
