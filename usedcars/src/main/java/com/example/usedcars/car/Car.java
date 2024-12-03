package com.example.usedcars.car;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record Car(
        @Id
        Integer id,
        @NotEmpty
        String make,
        String model,
        @Min(1900) @Max(2025) 
        int year, 
        String color,
        @Positive 
        int mileage,
        String vin,
        Status status,
        @Version
        Integer version
        ) {

        public Car {
                if (mileage < 0) {
                        throw new IllegalArgumentException("Mileage must be greater than 0");
                }
                if (year < 1900 || year > 2025) {
                        throw new IllegalArgumentException("Year must be between 1900 and 2025");
                }
                if (vin.length() != 17) {
                        throw new IllegalArgumentException("VIN must be 17 characters long");
                }
        }

}
