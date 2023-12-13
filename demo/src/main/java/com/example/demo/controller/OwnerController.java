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

import com.example.demo.model.Owner;
import com.example.demo.repository.OwnerRepository;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    
    private final OwnerRepository ownerRepository;
    
    public OwnerController(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }
    
    @GetMapping
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable long id) {
        Optional<Owner> ownerOptional = ownerRepository.findById(id);
        return ownerOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public Owner createOwner(@RequestBody Owner owner) {
        return ownerRepository.save(owner);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Owner> updateOwner(@PathVariable long id, @RequestBody Owner updatedOwner) {
        Optional<Owner> ownerOptional = ownerRepository.findById(id);
        if (ownerOptional.isPresent()) {
            Owner owner = ownerOptional.get();
            owner.setName(updatedOwner.getName());
            owner.setContactInformation(updatedOwner.getContactInformation());
            ownerRepository.save(owner);
            return ResponseEntity.ok(owner);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable long id) {
        Optional<Owner> ownerOptional = ownerRepository.findById(id);
        if (ownerOptional.isPresent()) {
            ownerRepository.delete(ownerOptional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}