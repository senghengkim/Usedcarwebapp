package com.example.usedcars.dealership;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

@Table("Dealership")
public record Dealership(
        @Id
        Integer id,
        @Column("name")
        String name,
        @Column("phone_number")
        String phoneNumber,
        @Column("address")
        String address,
        @Column("email")
        String email
) {
}