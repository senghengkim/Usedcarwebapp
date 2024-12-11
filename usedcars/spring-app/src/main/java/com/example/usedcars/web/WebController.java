package com.example.usedcars.web;

import com.example.usedcars.car.Car;
import com.example.usedcars.car.CarRepository;
import com.example.usedcars.sale.SaleRepository;
import com.example.usedcars.dealership.DealershipRepository;
import com.example.usedcars.listing.ListingRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class WebController {

    private final CarRepository carRepository;
    private final SaleRepository saleRepository;
    private final DealershipRepository dealershipRepository;
    private final ListingRepository listingRepository;

    public WebController(CarRepository carRepository, SaleRepository saleRepository, DealershipRepository dealershipRepository, ListingRepository listingRepository) {
        this.carRepository = carRepository;
        this.saleRepository = saleRepository;
        this.dealershipRepository = dealershipRepository;
        this.listingRepository = listingRepository;
    }

    @GetMapping("")
    public String index(Model model, 
                        @RequestParam(value = "make", required = false) String make, 
                        @RequestParam(value = "model", required = false) String modelParam,
                        @RequestParam(value = "minPrice", required = false) Double minPrice,
                        @RequestParam(value = "maxPrice", required = false) Double maxPrice,
                        @RequestParam(value = "mileage", required = false) Integer mileage) {
        List<Car> cars;
        if ((make == null || make.isEmpty()) && (modelParam == null || modelParam.isEmpty())) {
            if (minPrice != null && maxPrice != null && mileage != null) {
                cars = carRepository.findByPriceRangeAndMileage(minPrice, maxPrice, mileage);
            } else if (minPrice != null && maxPrice != null) {
                cars = carRepository.findByPriceRange(minPrice, maxPrice);
            } else if (mileage != null) {
                cars = carRepository.findByMileageLessThanEqual(mileage);
            } else {
                cars = carRepository.findAll();
            }
        } else if (make != null && !make.isEmpty() && (modelParam == null || modelParam.isEmpty())) {
            if (minPrice != null && maxPrice != null && mileage != null) {
                cars = carRepository.findByMakeAndPriceRangeAndMileage(make, minPrice, maxPrice, mileage);
            } else if (minPrice != null && maxPrice != null) {
                cars = carRepository.findByMakeAndPriceRange(make, minPrice, maxPrice);
            } else if (mileage != null) {
                cars = carRepository.findByMakeAndMileageLessThanEqual(make, mileage);
            } else {
                cars = carRepository.findByMake(make);
            }
        } else if (make != null && !make.isEmpty() && modelParam != null && !modelParam.isEmpty()) {
            if (minPrice != null && maxPrice != null && mileage != null) {
                cars = carRepository.findByMakeModelPriceRangeAndMileage(make, modelParam, minPrice, maxPrice, mileage);
            } else if (minPrice != null && maxPrice != null) {
                cars = carRepository.findByMakeModelAndPriceRange(make, modelParam, minPrice, maxPrice);
            } else if (mileage != null) {
                cars = carRepository.findByMakeModelAndMileageLessThanEqual(make, modelParam, mileage);
            } else {
                cars = carRepository.findByMakeAndModel(make, modelParam);
            }
        } else {
            cars = carRepository.findAll();
        }
        model.addAttribute("cars", cars);
        return "index";
    }

    @GetMapping("/cars")
    public String cars(Model model){
        model.addAttribute("cars", carRepository.findAll());
        return "cars";
    }

    @GetMapping("/listings")
    public String listings(Model model) {
        model.addAttribute("listings", listingRepository.findAll());
        return "listings"; // This will return the listings.html file from the templates directory
    }

    @GetMapping("/dealerships")
    public String dealerships(Model model) {
        model.addAttribute("dealerships", dealershipRepository.findAll());
        return "dealerships"; // This will return the dealerships.html file from the templates directory
    }

    @GetMapping("/sales")
    public String sales(Model model) {
        model.addAttribute("sales", saleRepository.findAll());
        return "sales"; // This will return the sales.html file from the templates directory
    }
}