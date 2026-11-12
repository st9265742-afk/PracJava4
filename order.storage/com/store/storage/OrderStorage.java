package com.store.storage;

import com.store.processing.Order;
import com.store.processing.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderStorage {

    private final List<Order<? extends Product>> orders =
            new ArrayList<>();

    public void addOrder(Order<? extends Product> order) {
        orders.add(order);
    }

    public List<Order<? extends Product>> getOrders() {
        return orders;
    }
}