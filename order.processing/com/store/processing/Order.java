package com.store.processing;

public class Order<T extends Product> {

    private static int counter = 0;

    private final int id;
    private final T product;

    public Order(T product) {
        this.id = ++counter;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public T getProduct() {
        return product;
    }

    public void display() {
        System.out.println(
            "Order #" + id +
            " | Product: " + product.getName() +
            " | Price: $" + product.getPrice()
        );
    }
}