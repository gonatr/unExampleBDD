package com.appium.pageObject.product;

import java.util.List;

public class Shipping {
    private final List<ProductPrice> products;

    public Shipping(List<ProductPrice> products) {
        this.products = products;
    }

    public double getTotal() {
        return products.stream().mapToDouble(products -> products.getUnitPrice() * products.getQuantity()).sum();
    }
}
