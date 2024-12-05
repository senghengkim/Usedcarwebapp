package com.example.usedcars.car;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface CarRepository extends ListCrudRepository<Car, Integer> {

    List<Car> findAllByStatus(String status);

    List<Car> findAllByColorAndStatus(String color, String status);

    @Query("SELECT * FROM Car WHERE year > :year")
    List<Car> findCarsMadeAfter(@Param("year") int year);
    
    
}
