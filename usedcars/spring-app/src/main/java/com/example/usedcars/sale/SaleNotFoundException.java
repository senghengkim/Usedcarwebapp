package com.example.usedcars.sale;

public class SaleNotFoundException extends RuntimeException {
    public SaleNotFoundException(Integer id) {
        super("Sale not found: " + id);
    }
}