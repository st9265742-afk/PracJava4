package com.store.processing;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Clothing extends Product {

    private String size;
    private String material;

    public Clothing(String name, double price,
                    String size, String material) {
        super(name, price);
        this.size = size;
        this.material = material;
    }
}
