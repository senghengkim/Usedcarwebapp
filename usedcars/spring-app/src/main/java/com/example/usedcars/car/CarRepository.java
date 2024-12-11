package com.example.usedcars.car;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Integer> {
    List<Car> findAll();

    @Query("SELECT * FROM Car WHERE price BETWEEN :minPrice AND :maxPrice")
    List<Car> findByPriceRange(Double minPrice, Double maxPrice);

    @Query("SELECT * FROM Car WHERE make = :make AND price BETWEEN :minPrice AND :maxPrice")
    List<Car> findByMakeAndPriceRange(String make, Double minPrice, Double maxPrice);

    @Query("SELECT * FROM Car WHERE make = :make AND model = :model AND price BETWEEN :minPrice AND :maxPrice")
    List<Car> findByMakeModelAndPriceRange(String make, String model, Double minPrice, Double maxPrice);

    @Query("SELECT * FROM Car WHERE mileage <= :mileage")
    List<Car> findByMileageLessThanEqual(Integer mileage);

    @Query("SELECT * FROM Car WHERE make = :make AND mileage <= :mileage")
    List<Car> findByMakeAndMileageLessThanEqual(String make, Integer mileage);

    @Query("SELECT * FROM Car WHERE make = :make AND model = :model AND mileage <= :mileage")
    List<Car> findByMakeModelAndMileageLessThanEqual(String make, String model, Integer mileage);

    @Query("SELECT * FROM Car WHERE price BETWEEN :minPrice AND :maxPrice AND mileage <= :mileage")
    List<Car> findByPriceRangeAndMileage(Double minPrice, Double maxPrice, Integer mileage);

    @Query("SELECT * FROM Car WHERE make = :make AND price BETWEEN :minPrice AND :maxPrice AND mileage <= :mileage")
    List<Car> findByMakeAndPriceRangeAndMileage(String make, Double minPrice, Double maxPrice, Integer mileage);

    @Query("SELECT * FROM Car WHERE make = :make AND model = :model AND price BETWEEN :minPrice AND :maxPrice AND mileage <= :mileage")
    List<Car> findByMakeModelPriceRangeAndMileage(String make, String model, Double minPrice, Double maxPrice, Integer mileage);

    List<Car> findByMake(String make);

    List<Car> findByMakeAndModel(String make, String model);

    @Query("SELECT * FROM Car WHERE status = :status")
    List<Car> findAllByStatus(String status);

    @Query("SELECT * FROM Car WHERE color = :color AND status = :status")
    List<Car> findAllByColorAndStatus(String color, String status);

    @Query("SELECT * FROM Car WHERE year > :year")
    List<Car> findCarsMadeAfter(int year);

    @Query("SELECT DISTINCT make FROM Car")
    List<String> findDistinctMakes();

    @Query("SELECT DISTINCT model FROM Car")
    List<String> findDistinctModels();

    @Query("SELECT DISTINCT model FROM Car WHERE make = :make")
    List<String> findDistinctModelsByMake(String make);
}