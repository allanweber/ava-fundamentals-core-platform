package com.allan.multithreading.concurrency.manually_synchronized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        BankAccount bankAccount = new BankAccount(400);

        int id = 0;
//        List<TxWorker> workers = Arrays.asList(
//
//                new TxWorker(++id, bankAccount, 'w', 10), //90
//                new TxWorker(++id, bankAccount, 'w', 10), //80
//                new TxWorker(++id, bankAccount, 'w', 10), //70
//                new TxWorker(++id, bankAccount, 'd', 10), //80
//                new TxWorker(++id, bankAccount, 'd', 20), //100
//                new TxWorker(++id, bankAccount, 'd', 30), //130
//                new TxWorker(++id, bankAccount, 'w', 10), //120
//                new TxWorker(++id, bankAccount, 'd', 20), //140
//                new TxWorker(++id, bankAccount, 'w', 10), //130
//                new TxWorker(++id, bankAccount, 'd', 20)  //150
//
//        );

        List<TxPromoWorker> workers = Arrays.asList(
                new TxPromoWorker(++id, bankAccount, 'w', 10), //390
                new TxPromoWorker(++id, bankAccount, 'w', 10), //380
                new TxPromoWorker(++id, bankAccount, 'w', 10), //370
                new TxPromoWorker(++id, bankAccount, 'd', 230), //600 -> 610
                new TxPromoWorker(++id, bankAccount, 'w', 20), //590
                new TxPromoWorker(++id, bankAccount, 'w', 10), //580
                new TxPromoWorker(++id, bankAccount, 'w', 10), //570
                new TxPromoWorker(++id, bankAccount, 'w', 10), //560
                new TxPromoWorker(++id, bankAccount, 'w', 10), //550
                new TxPromoWorker(++id, bankAccount, 'w', 10)  //540
        );
        
        for (TxWorker worker : workers) {
            executorService.submit(worker);
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("FINAL BALANCE-> " + bankAccount.getBalance());
    }
}
