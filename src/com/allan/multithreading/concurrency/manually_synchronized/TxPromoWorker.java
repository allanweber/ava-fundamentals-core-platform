package com.allan.multithreading.concurrency.manually_synchronized;

public class TxPromoWorker extends TxWorker {
    public TxPromoWorker(int id, BankAccount bankAccount, char txType, int amount) {
        super(id, bankAccount, txType, amount);
    }

    public void run (){
        int startBalance = bankAccount.getBalance();
        if(txType == 'w'){
            bankAccount.withdrawal(amount);
        } else if (txType == 'd'){
            synchronized (bankAccount){
                bankAccount.deposit(amount);
                if(bankAccount.getBalance() > 500){
                    int bonus = (int)((bankAccount.getBalance() - 500) * 0.1);
                    bankAccount.deposit(bonus);
                }
            }
        }
        int endBalance = bankAccount.getBalance();

        System.out.println("Start Balance: "
                + startBalance
                + " --- End Balance: "
                + endBalance
                + " --- Worker: " + this.id);
    }
}
