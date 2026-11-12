package com.store.processing;

public class OrderProcessor<T extends Product> {

    private final Order<T> order;

    public OrderProcessor(Order<T> order) {
        this.order = order;
    }

    public void processOrder() {
        try {
            System.out.println(
                "Thread: " + Thread.currentThread().getName()
            );

            System.out.println(
                "Processing order #" + order.getId()
            );

            order.display();

            Thread.sleep(1000);

            System.out.println(
                "Order #" + order.getId() + " completed!\n"
            );

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

            System.out.println(
                "Order processing interrupted!"
            );
        }
    }
}