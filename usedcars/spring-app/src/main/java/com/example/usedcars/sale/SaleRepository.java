package com.example.usedcars.sale;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface SaleRepository extends ListCrudRepository<Sale, Integer>  {
    @Query("SELECT * FROM Sale WHERE sale_price > :price")
    List<Sale> findSalesByPrice(@Param("price") Double price);
    
    
}
