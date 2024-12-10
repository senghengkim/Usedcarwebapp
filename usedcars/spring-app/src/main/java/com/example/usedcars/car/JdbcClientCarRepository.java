// package com.example.usedcars.car;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

// import org.springframework.jdbc.core.simple.JdbcClient;
// import org.springframework.util.Assert;
// import org.springframework.stereotype.Repository;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;


// @Repository
// public class JdbcClientCarRepository {

//     private static final Logger log = LoggerFactory.getLogger(JdbcClientCarRepository.class);
//     private final JdbcClient jdbcClient;

//     public JdbcClientCarRepository(JdbcClient jdbcClient) {
//         this.jdbcClient = jdbcClient;
//     } 

//     public List<Car> findAll() {
//         return jdbcClient.sql("SELECT * FROM Car") // Updated table name
//                 .query(Car.class)
//                 .list();
//     }
 
//     public Optional<Car> findById(Integer id) {
//         return jdbcClient.sql("SELECT * FROM Car WHERE id = :id") // Updated table name
//                 .param("id", id) 
//                 .query(Car.class)
//                 .optional();
//     }

//     public void create(Car car) {
//         var updated = jdbcClient.sql("INSERT INTO Car(id, make, model, `year`, color, mileage, vin, status) values(?,?,?,?,?,?,?,?)")
//                 .params(List.of(car.id(), car.make(), car.model(), car.year(), car.color(), car.mileage(), car.vin(), car.status().toString()))
//                 .update();

//         Assert.state(updated == 1, "Failed to create car");
//     }

//     public void update(Car car) {
//         var updated = jdbcClient.sql("UPDATE Car SET make = ?, model = ?, `year` = ?, color = ?, mileage = ?, vin = ?, status = ? WHERE id = ?")
//                 .params(List.of(car.make(), car.model(), car.year(), car.color(), car.mileage(), car.vin(), car.status().toString(), car.id()))
//                 .update();

//         Assert.state(updated == 1, "Failed to update car");
//     }

//     public void delete(Integer id) {
//         var deleted = jdbcClient.sql("DELETE FROM Car WHERE id = ?")
//                 .param("id", id)
//                 .update();

//         Assert.state(deleted == 1, "Failed to delete car");
//     }

//     public int count() {return jdbcClient.sql("SELECT * FROM Car").query().listOfRows().size(); }

//     public void saveAll(List<Car> cars) {
//         cars.stream().forEach(this::create);
//     }

//     public List<Car> findByMake(String make) {
//         return jdbcClient.sql("SELECT * FROM Car WHERE make = :make")
//                 .param("make", make)
//                 .query(Car.class)
//                 .list();
//     }

//     public List<Car> findByYear(int year) {
//         return jdbcClient.sql("SELECT * FROM Car WHERE year = :year")
//                 .param("year", year)
//                 .query(Car.class)
//                 .list();
//     }
// }
