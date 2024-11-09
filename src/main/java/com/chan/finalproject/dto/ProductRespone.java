package com.chan.finalproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ProductRespone {
    private double price;
    private String productName;

    public ProductRespone(double price) {
        this.price = price;
    }
    public ProductRespone(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }
}
