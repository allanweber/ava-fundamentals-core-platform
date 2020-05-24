package com.allan.collections._2_order;

import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Product product1 = new Product(1, "PC", 1000D);
        Product product2 = new Product(2, "Computer", 1000D);
        Product product3 = new Product(3, "Car", 10000D);

        Set<Product> products = new TreeSet<>(Product.BY_NAME);
        products.add(product1);
        products.add(product2);
        products.add(product3);

        for (Product prd: products) {
            System.out.println(prd);
        }
    }
}
