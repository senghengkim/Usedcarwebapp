package com.example.usedcars.dealership;

public class DealershipNotFoundException extends RuntimeException {
    public DealershipNotFoundException(Integer id) {
        super("Dealership not found: " + id);
    }
}