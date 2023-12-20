package com.example.demo.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.RentalContract;
import com.example.demo.repository.RentalContractRepository;
import com.example.demo.service.RentalContractService;

@Service
public class RentalContractServiceImpl implements RentalContractService {

    private RentalContractRepository rentalContractRepository;

    @Autowired
    public RentalContractServiceImpl(RentalContractRepository rentalContractRepository) {
        this.rentalContractRepository = rentalContractRepository;
    }

    @Override
    public List<RentalContract> getAllRentalContracts() {
        return rentalContractRepository.findAll();
    }

    @Override
    public RentalContract getRentalContractById(Long id) {
        Optional<RentalContract> optionalRentalContract = rentalContractRepository.findById(id);
        return optionalRentalContract.orElse(null);
    }

    @Override
    public RentalContract saveRentalContract(RentalContract rentalContract) {
        return rentalContractRepository.save(rentalContract);
    }

    @Override
    public RentalContract updateRentalContract(Long id, RentalContract rentalContract) {
        Optional<RentalContract> optionalRentalContract = rentalContractRepository.findById(id);
        if (optionalRentalContract.isPresent()) {
            RentalContract existingRentalContract = optionalRentalContract.get();
            existingRentalContract.setProperty(rentalContract.getProperty());
            existingRentalContract.setOwner(rentalContract.getOwner());
            existingRentalContract.setTenant(rentalContract.getTenant());
            existingRentalContract.setMonthlyRent(rentalContract.getMonthlyRent());
            return rentalContractRepository.save(existingRentalContract);
        }
        return null;
    }

    @Override
    public void deleteRentalContract(Long id) {
        rentalContractRepository.deleteById(id);
    }
}
