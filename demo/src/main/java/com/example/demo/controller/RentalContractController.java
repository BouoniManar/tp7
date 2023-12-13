package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RentalContract;
import com.example.demo.repository.RentalContractRepository;


@RestController
@RequestMapping("/contracts")
public class RentalContractController {
    
    private final RentalContractRepository rentalContractRepository;
    
    public RentalContractController(RentalContractRepository rentalContractRepository) {
        this.rentalContractRepository = rentalContractRepository;
    }
    
    @GetMapping
    public List<RentalContract> getAllRentalContracts() {
        return rentalContractRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<RentalContract> getRentalContractById(@PathVariable long id) {
        Optional<RentalContract> rentalContractOptional = rentalContractRepository.findById(id);
        return rentalContractOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public RentalContract createRentalContract(@RequestBody RentalContract rentalContract) {
        return rentalContractRepository.save(rentalContract);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<RentalContract> updateRentalContract(@PathVariable long id, @RequestBody RentalContract updatedRentalContract) {
        Optional<RentalContract> rentalContractOptional = rentalContractRepository.findById(id);
        if (rentalContractOptional.isPresent()) {
            RentalContract rentalContract = rentalContractOptional.get();
            rentalContract.setProperty(updatedRentalContract.getProperty());
            rentalContract.setOwner(updatedRentalContract.getOwner());
            rentalContract.setTenant(updatedRentalContract.getTenant());
            rentalContract.setMonthlyRent(updatedRentalContract.getMonthlyRent());
            rentalContractRepository.save(rentalContract);
            return ResponseEntity.ok(rentalContract);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRentalContract(@PathVariable long id) {
        Optional<RentalContract> rentalContractOptional = rentalContractRepository.findById(id);
        if (rentalContractOptional.isPresent()) {
            rentalContractRepository.delete(rentalContractOptional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}