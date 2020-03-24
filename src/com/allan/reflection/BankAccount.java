package com.allan.reflection;

public class BankAccount {
    private int id;
    private int balance;

    public BankAccount(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public BankAccount(int id) {
        this.id = id;
        this.balance = 0;
    }

    public synchronized int getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }

    public synchronized void deposit(int amount){
        balance += amount;
    }

    public synchronized void withdrawal(int amount){
        balance -= amount;
    }
}
