package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Property;



public interface PropertyRepository extends JpaRepository<Property, Long>{

    Optional<Property> getById(Integer id);
}