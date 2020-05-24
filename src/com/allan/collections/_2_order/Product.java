package com.allan.collections._2_order;

import java.util.Comparator;
import java.util.Objects;

public class Product {

    public static final Comparator<Product> BY_NAME = Comparator.comparing(Product::getName);

    private Integer id;

    private String name;

    private Double price;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Product(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
