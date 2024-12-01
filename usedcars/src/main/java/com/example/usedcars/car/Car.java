package com.example.usedcars.car;

public record Car(
        Integer id,
        String make,
        String model, 
        int year, 
        String color, 
        int mileage, 
        String vin,
        Status status
        ) {

}
