package com.allan.multithreading.examples.runnable;

import com.allan.multithreading.examples.Helper;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String[] inFiles = Helper.getInFile();
        String[] outFiles = Helper.getOutFile();

        long startTime = System.currentTimeMillis();

        Thread[] threads = new Thread[inFiles.length];

        for (int i = 0; i < inFiles.length; i++) {
            Adder adder = new Adder(inFiles[i], outFiles[i]);
            threads[i] = new Thread(adder);
            threads[i].start();
        }

        for (Thread thread: threads)
            thread.join();

        long endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " millis");
    }
}
