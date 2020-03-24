package com.allan.multithreading.concurrency.synchronized_statment;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        BankAccount bankAccount = new BankAccount(100);

        for (int i = 0; i < 5; i++) {
            Worker worker = new Worker(bankAccount, i +1);
            executorService.submit(worker);
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
