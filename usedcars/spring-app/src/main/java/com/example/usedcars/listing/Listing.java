package com.example.usedcars.listing;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record Listing(
        @Id
        Integer id,
        @NotNull
        @JsonProperty("car_id")
        @Column("car_id")
        Integer carId,
        String description,
        Double price,
        @NotNull
        LocalDate date,
        @NotNull
        @JsonProperty("dealership_id")
        @Column("dealership_id")
        Integer dealershipId
) {
}