package com.allan.multithreading.concurrency.synchronized_method;

public class Worker implements Runnable {

    private Integer id;
    private BankAccount bankAccount;

    public Worker(BankAccount bankAccount, Integer id) {
        this.bankAccount = bankAccount;
        this.id = id;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            int startBalance = bankAccount.getBalance();
            bankAccount.deposit(10);
            int endBalance = bankAccount.getBalance();

            System.out.println("Start Balance: "
                    + startBalance
                    + " --- End Balance: "
                    + endBalance
            + " --- Worker: " + this.id);
        }

    }
}
