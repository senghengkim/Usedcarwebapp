package com.example.usedcars.sale;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Table("Sale")
public class Sale {
    @Id
    private Integer id;

    @NotNull
    @Column("sale_date")
    private LocalDate saleDate;

    @NotNull
    @Column("sale_price")
    private Double salePrice;

    @NotNull
    @Column("payment_method")
    private String paymentMethod;

    @NotNull
    @Column("listing_id")
    private Integer listingId;

    // Constructor
    public Sale(Integer id, LocalDate saleDate, Double salePrice, String paymentMethod, Integer listingId) {
        this.id = id;
        this.saleDate = saleDate;
        this.salePrice = salePrice;
        this.paymentMethod = paymentMethod;
        this.listingId = listingId;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getListingId() {
        return listingId;
    }

    public void setListingId(Integer listingId) {
        this.listingId = listingId;
    }
}