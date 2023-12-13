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

import com.example.demo.model.Property;
import com.example.demo.repository.PropertyRepository;

@RestController
@RequestMapping("/properties")
public class PropertyController {
    
    private final PropertyRepository propertyRepository;
    
    public PropertyController(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }
    
    @GetMapping
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable long id) {
        Optional<Property> propertyOptional = propertyRepository.findById(id);
        return propertyOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public Property createProperty(@RequestBody Property property) {
        return propertyRepository.save(property);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Property> updateProperty(@PathVariable long id, @RequestBody Property updatedProperty) {
        Optional<Property> propertyOptional = propertyRepository.findById(id);
        if (propertyOptional.isPresent()) {
            Property property = propertyOptional.get();
            property.setAddress(updatedProperty.getAddress());
            property.setPrice(updatedProperty.getPrice());
            propertyRepository.save(property);
            return ResponseEntity.ok(property);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable long id) {
        Optional<Property> propertyOptional = propertyRepository.findById(id);
        if (propertyOptional.isPresent()) {
            propertyRepository.delete(propertyOptional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
