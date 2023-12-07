package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.RentalContract;

public interface RentalContractRepository extends JpaRepository<RentalContract, Long>{
}