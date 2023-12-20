package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.RentalContract;

@Service
public interface RentalContractService {
    List<RentalContract> getAllRentalContracts();
    RentalContract getRentalContractById(Long id);
    RentalContract saveRentalContract(RentalContract rentalContract);
    RentalContract updateRentalContract(Long id, RentalContract rentalContract);
    void deleteRentalContract(Long id);
}