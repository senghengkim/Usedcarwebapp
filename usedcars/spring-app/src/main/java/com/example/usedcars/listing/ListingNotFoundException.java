package com.example.usedcars.listing;

public class ListingNotFoundException extends RuntimeException {
    public ListingNotFoundException(Integer id) {
        super("Listing not found: " + id);
    }
}