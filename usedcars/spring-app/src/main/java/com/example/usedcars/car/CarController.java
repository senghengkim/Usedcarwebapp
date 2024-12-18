package com.example.usedcars.car;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    
    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    //Method that returns a list of cars
    @GetMapping("")
    List<Car> findAll(){
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    Car findById(@PathVariable Integer id){
         Optional<Car> car = carRepository.findById(id);
         if(car.isEmpty()){
             throw new CarNotFoundException(id);
         }
         return car.get();
    }

    //post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Car car){
        carRepository.save(car);
    }

    //put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody Car car, @PathVariable Integer id){
        carRepository.save(car);
    }
    //delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        carRepository.delete(carRepository.findById(id).get());
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}/status")
    public void updateStatus(@PathVariable Integer id, @RequestParam("status") String status) {
        Optional<Car> carOptional = carRepository.findById(id);
        if (carOptional.isPresent()) {
            Car car = carOptional.get();
            car.setStatus(status);
            carRepository.save(car);
        } else {
            throw new CarNotFoundException(id);
        }
    }
    
    @GetMapping("/status/{status}")
    List<Car> findAllByStatus(@PathVariable String status){
        return carRepository.findAllByStatus(status);
    }

    @GetMapping("/color/{color}/status/{status}")
    List<Car> findAllByColorAndStatus(@PathVariable String color, @PathVariable String status){
        return carRepository.findAllByColorAndStatus(color, status);
    }

    @GetMapping("/year/after/{year}")
    List<Car> findCarsMadeAfter(@PathVariable int year) {
        return carRepository.findCarsMadeAfter(year);
    }

    @GetMapping("/makes")
    List<String> findDistinctMakes() {
        return carRepository.findDistinctMakes();
    }

    @GetMapping("/models")
    List<String> findDistinctModels() {
        return carRepository.findDistinctModels();
    }

    @GetMapping("/models/{make}")
    List<String> findDistinctModelsByMake(@PathVariable String make) {
        return carRepository.findDistinctModelsByMake(make);
    }



}
