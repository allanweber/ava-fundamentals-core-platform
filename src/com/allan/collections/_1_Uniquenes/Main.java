package com.allan.collections._1_Uniquenes;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Product product1 = new Product(1, "PC", 1000D);
        Product product2 = new Product(1, "Computer", 1000D);
        Product product3 = new Product(3, "Car", 10000D);

        Set<Product> products = new HashSet<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        System.out.println("Products size 2 == " + products.size());
    }
}
