package com.store.threads;

import com.store.processing.*;
import com.store.storage.OrderStorage;

import net.datafaker.Faker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        Faker faker = new Faker();

        OrderStorage storage = new OrderStorage();

        // Створення товарів через Builder

        Clothing clothing1 = Clothing.builder()
                .name(faker.commerce().productName())
                .price(Double.parseDouble(
                        faker.commerce().price(10, 100)))
                .size("M")
                .material("Cotton")
                .build();

        Clothing clothing2 = Clothing.builder()
                .name(faker.commerce().productName())
                .price(Double.parseDouble(
                        faker.commerce().price(10, 100)))
                .size("L")
                .material("Polyester")
                .build();

        Electronics electronics1 = Electronics.builder()
                .name(faker.commerce().productName())
                .price(Double.parseDouble(
                        faker.commerce().price(100, 1000)))
                .brand(faker.company().name())
                .warranty(24)
                .build();

        Electronics electronics2 = Electronics.builder()
                .name(faker.commerce().productName())
                .price(Double.parseDouble(
                        faker.commerce().price(100, 1000)))
                .brand(faker.company().name())
                .warranty(12)
                .build();

        // Створення замовлень

        storage.addOrder(new Order<>(clothing1));
        storage.addOrder(new Order<>(clothing2));
        storage.addOrder(new Order<>(electronics1));
        storage.addOrder(new Order<>(electronics2));

        // Створення пулу потоків

        ExecutorService executor =
                Executors.newFixedThreadPool(2);

        // Lambda Expression

        storage.getOrders().forEach(order ->
                executor.submit(() -> {
                    OrderProcessor processor =
                            new OrderProcessor(order);

                    processor.processOrder();
                })
        );

        executor.shutdown();
    }
}