package com.example.usedcars.dealership;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/dealerships")
public class DealershipController {

    private final DealershipRepository dealershipRepository;

    public DealershipController(DealershipRepository dealershipRepository) {
        this.dealershipRepository = dealershipRepository;
    }

    @GetMapping("")
    List<Dealership> findAll(){
        return dealershipRepository.findAll();
    }

    @GetMapping("/{id}")
    Dealership findById(@PathVariable Integer id){
        Optional<Dealership> dealership = dealershipRepository.findById(id);
        if(dealership.isEmpty()){
            throw new DealershipNotFoundException(id);
        }
        return dealership.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    void create(@Valid @RequestBody Dealership dealership){
        dealershipRepository.save(dealership);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody Dealership dealership, @PathVariable Integer id){
        dealershipRepository.save(dealership);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        dealershipRepository.deleteById(id);
    }

    @GetMapping("/address/{address}")
    List<Dealership> findDealershipsByAddress(@PathVariable String address){
        return dealershipRepository.findDealershipsByAddress(address);
    }

    @GetMapping("/name/{name}")
    List<Dealership> findDealershipsByName(@PathVariable String name){
        return dealershipRepository.findDealershipsByName(name);
    }
}