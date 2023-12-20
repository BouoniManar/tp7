package com.example.demo.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Property;

@Service
public interface PropertyService {
    List<Property> getAllProperties();
    Property getPropertyById(Long id);
    Property saveProperty(Property property);
    Property updateProperty(Long id, Property property);
    void deleteProperty(Long id);
}