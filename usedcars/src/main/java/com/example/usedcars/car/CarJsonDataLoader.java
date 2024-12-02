// package com.example.usedcars.car;

// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;

// import java.io.InputStream;
// import java.io.IOException;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

// import com.fasterxml.jackson.core.type.TypeReference;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.example.usedcars.car.Cars;

// @Component
// public class CarJsonDataLoader implements CommandLineRunner {

//     private final Logger log = LoggerFactory.getLogger(CarJsonDataLoader.class);
//     private final CarRepository carRepository;
//     private final ObjectMapper objectMapper;

//     public CarJsonDataLoader(CarRepository carRepository, ObjectMapper objectMapper) {
//         this.carRepository = carRepository;
//         this.objectMapper = objectMapper;
//     }

//     @Override
//     public void run(String... args) throws Exception {
//         if (carRepository.count() == 0) {
//             try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/cars.json")) {
//                 Cars allCars = objectMapper.readValue(inputStream, Cars.class);
//                 log.info("Reading {} cars from JSON data and saving to a database.", allCars.cars().size());
//                 carRepository.saveAll(allCars.cars());
//             } catch (IOException e) {
//                 throw new RuntimeException("Failed to read JSON data", e);
//             }
//         } else {
//             log.info("Not loading Cars from JSON data because the collection contains data.");
//         }
//     }
// }
