package com.allan.multithreading.examples.simple;

import com.allan.multithreading.examples.Helper;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String[] inFiles = Helper.getInFile();
        String[] outFiles = Helper.getOutFile();

        long startTime = System.currentTimeMillis();

        try {
            for (int i = 0; i < inFiles.length ; i++) {
                Adder adder = new Adder(inFiles[i], outFiles[i]);
                adder.doAdd();;
            }
        } catch (IOException e){
            System.out.println(e);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " millis");
    }
}
