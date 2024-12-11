package com.example.usedcars.sale;

import java.time.LocalDate;
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

import com.example.usedcars.car.Car;
import com.example.usedcars.car.CarRepository;
import com.example.usedcars.car.Status;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    private final SaleRepository saleRepository;
    private final CarRepository carRepository;

    public SaleController(SaleRepository saleRepository, CarRepository carRepository) {
        this.saleRepository = saleRepository;
        this.carRepository = carRepository;
    }

    @GetMapping("")
    List<Sale> findAll() {
        return saleRepository.findAll();
    }

    @GetMapping("/{id}")
    Sale findById(@PathVariable Integer id) {
        Optional<Sale> sale = saleRepository.findById(id);
        if (sale.isEmpty()) {
            throw new SaleNotFoundException(id);
        }
        return sale.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    void create(@Valid @RequestBody Sale sale) {
        saleRepository.save(sale);
        updateCarStatus(sale.getListingId(), Status.SOLD);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/createCustom")
    public void createCustom(
            @RequestParam("saleDate") @Valid LocalDate saleDate,
            @RequestParam("salePrice") Double salePrice,
            @RequestParam("paymentMethod") String paymentMethod,
            @RequestParam("listingId") Integer listingId) {
        Sale sale = new Sale(null, saleDate, salePrice, paymentMethod, listingId);
        saleRepository.save(sale);
        updateCarStatus(listingId, Status.SOLD);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody Sale sale, @PathVariable Integer id) {
        saleRepository.save(sale);
        updateCarStatus(sale.getListingId(), Status.SOLD);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        Optional<Sale> sale = saleRepository.findById(id);
        if (sale.isPresent()) {
            updateCarStatus(sale.get().getListingId(), Status.AVAILABLE);
            saleRepository.deleteById(id);
        }
    }

    private void updateCarStatus(Integer listingId, Status status) {
        Optional<Car> car = carRepository.findById(listingId);
        if (car.isPresent()) {
            Car updatedCar = car.get().withStatus(status);
            carRepository.save(updatedCar);
        }
    }

    @GetMapping("/price/{price}")
    List<Sale> findSalesByPrice(@PathVariable Double price) {
        return saleRepository.findSalesByPrice(price);
    }
}