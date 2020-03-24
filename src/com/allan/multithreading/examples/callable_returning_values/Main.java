package com.allan.multithreading.examples.callable_returning_values;

import com.allan.multithreading.examples.Helper;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String[] inFiles = Helper.getInFile();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        long startTime = System.currentTimeMillis();

        Future<Integer>[] results = new Future[inFiles.length];

        for (int i = 0; i < inFiles.length; i++) {
            Adder adder = new Adder(inFiles[i]);
            results[i] = executorService.submit(adder);
        }

        for (Future<Integer> result: results){
            Integer value = result.get();
            System.out.println("Total: " + value);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " millis");
    }
}
