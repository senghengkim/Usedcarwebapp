package com.example.usedcars.listing;

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

@RestController
@RequestMapping("/api/listings")
public class ListingController {

    private final ListingRepository listingRepository;

    public ListingController(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    @GetMapping("")
    List<Listing> findAll() {
        return (List<Listing>) listingRepository.findAll();
    }

    @GetMapping("/{id}")
    Listing findById(@PathVariable Integer id) {
        Optional<Listing> listing = listingRepository.findById(id);
        if (listing.isEmpty()) {
            throw new ListingNotFoundException(id);
        }
        return listing.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Listing listing) {
        listingRepository.save(listing);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody Listing listing, @PathVariable Integer id) {
        listingRepository.save(listing);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        listingRepository.deleteById(id);
    }

    // Custom create method
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void createCustom(
            @RequestParam("carId") Integer carId,
            @RequestParam("description") String description,
            @RequestParam("price") Double price,
            @RequestParam("date") @Valid LocalDate date,
            @RequestParam("dealershipId") Integer dealershipId) {
        Listing listing = new Listing(null, carId, description, price, date, dealershipId);
        listingRepository.save(listing);
    }
}