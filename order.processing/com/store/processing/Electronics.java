package com.store.processing;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Electronics extends Product {

    private String brand;
    private int warranty;

    public Electronics(String name, double price,
                       String brand, int warranty) {
        super(name, price);
        this.brand = brand;
        this.warranty = warranty;
    }
}