package com.example.usedcars.dealership;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface DealershipRepository extends ListCrudRepository<Dealership, Integer> {
    
    @Query("SELECT * FROM Dealership WHERE address LIKE CONCAT ('%', :address, '%')")
    List<Dealership> findDealershipsByAddress(@Param("address") String address);
    
    @Query("SELECT * FROM Dealership WHERE name LIKE CONCAT('%', :name, '%')")
    List<Dealership> findDealershipsByName(@Param("name") String name);

}