package com.allan.multithreading.examples.callable_returning_values;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

public class Adder  implements Callable<Integer> {
    private String inFile;

    public Adder(String inFile) {
        this.inFile = inFile;
    }

    @Override
    public Integer call() throws IOException {
        return doAdd();
    }

    private int doAdd() throws IOException {
        int total = 0;
        String line = null;

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inFile))){
            while ((line = reader.readLine()) != null)
                total += Integer.parseInt(line);
        }

        return total;
    }
}
