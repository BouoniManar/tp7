package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Property;


public interface PropertyService {
Property saveProperty(Property property);
List<Property> getAllProperty();
Property getPropertyById(long id);
Property updateProperty(Property property, long id);
void deleteProperty(long id);
}