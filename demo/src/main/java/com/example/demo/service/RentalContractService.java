package com.example.demo.service;

import java.util.List;

import com.example.demo.model.RentalContract;




public interface RentalContractService {
RentalContract saveRentalContract(RentalContract rentalContract);
static List<RentalContract> getAllRentalContract() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAllRentalContract'");
}
RentalContract getRentalContractById(long id);
RentalContract updateRentalContract(RentalContract rentalContract, long id);
void deleteRentalContract(long id);
}