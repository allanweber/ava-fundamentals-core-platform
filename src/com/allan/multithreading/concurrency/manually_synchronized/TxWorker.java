package com.allan.multithreading.concurrency.manually_synchronized;

public class TxWorker implements Runnable {

    protected int id;
    protected BankAccount bankAccount;
    protected char txType;
    protected int amount;

    public TxWorker(int id, BankAccount bankAccount, char txType, int amount) {
        this.id = id;
        this.bankAccount = bankAccount;
        this.txType = txType;
        this.amount = amount;
    }

    @Override
    public void run() {

        int startBalance = bankAccount.getBalance();
        if(txType == 'w'){
            bankAccount.withdrawal(amount);
        } else if (txType == 'd'){
            bankAccount.deposit(amount);
        }
        int endBalance = bankAccount.getBalance();

        System.out.println("Start Balance: "
                + startBalance
                + " --- End Balance: "
                + endBalance
                + " --- Worker: " + this.id);

    }
}
