package com.example.demo.service.Impl;

import java.util.List;

import javax.management.relation.RelationNotFoundException;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.demo.model.RentalContract;
import com.example.demo.repository.RentalContractRepository;
import com.example.demo.service.RentalContractService;

@Service
public class RentalServiceImpl implements RentalContractService{
    
private RentalContractRepository rentalContractRepository;

public RentalContractRepository getRentalContractRepository() {
    return rentalContractRepository;
}
public void setRentalContractRepository(RentalContractRepository rentalContractRepository) {
    this.rentalContractRepository = rentalContractRepository;
}
public RentalServiceImpl(RentalContractRepository rentalContractRepository) {
super();
this.rentalContractRepository= rentalContractRepository;
}
@Override
public RentalContract saveRentalContract(RentalContract rentalContract) {
Object rentalContractt;
return RentalContractRepository.save(rentalContractRepository);

}
@Override
public List<RentalContract> getAllRentalContract()
return rentalContractRepository.findAll();
}
@Override
public RentalContract getRentalContractById(long id) {
// Optional<Employee> employee = employeeRepository.findById(id);
// if(employee.isPresent()) {
// return employee.get();
// }else {
// throw new ResourceNotFoundException("Employee", "Id", id);
// }
return rentalContractRepository.findById(id).orElseThrow(() ->
                        new
ResourceNotFoundException("RentalContract", "Id", id));

}
@Override
public RentalContract updateRentalContract(RentalContract rentalContract, long id) {
// we need to check whether employee with given id is exist inDB or not
RentalContract existingRentalContract =
RentalContractRepository.findById(id).orElseThrow(
() -> new ResourceNotFoundException("RentalContract",
"Id", id));
existingRentalContract.setProperty(rentalContract.getProperty());
existingRentalContract.setTenant(rentalContract.getTenant());
existingRentalContract.setMonthlyRent(rentalContract.getMonthlyRent());
existingRentalContract.setProperty(rentalContract.getProperty());
existingRentalContract.setOwner(rentalContract.getOwner());
// save existing employee to DB

rentalContractRepository.save(existingRentalContract);
return existingRentalContract;
}

@Override
public void deleteRentalContract(long id ) {
// check whether a employee exist in a DB or not
CrudRepository<RentalContract, Long> rentalContractRepositoryryry;
rentalContractRepository.findById(id).orElseThrow(() ->
                    new
RelationNotFoundException());
rentalContractRepository.deleteById(id);
}
