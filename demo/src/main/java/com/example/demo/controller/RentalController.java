package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RentalContract;
import com.example.demo.service.RentalContractService;

@RestController
@RequestMapping("/api/rentalContract")
public class RentalController {
    private static final long rentalContractId = 0;
    private RentalContractService rentalContractService;
    public RentalController(RentalContractService rentalContractService) {
        super();
        this.rentalContractService = rentalContractService;
}
    // build create employee REST API
@PostMapping()
public ResponseEntity<RentalContract> saveEmployee(@RequestBody RentalContract
rentalContract){
return new
ResponseEntity<RentalContract>(rentalContractService.saveRentalContract(rentalContract),
HttpStatus.CREATED);
}
// build get all employees REST API
@GetMapping
public List<RentalContract> getAllRentalContract(){
return RentalContractService.getAllRentalContract();
}
// build get employee by id REST API
// http://localhost:8080/api/employees/1
@GetMapping("{id}")
public ResponseEntity<RentalContract> getEmployeeById(@PathVariable("id")
long employeeId){
return new
ResponseEntity<RentalContract>(rentalContractService.getRentalContractById(rentalContractId),
HttpStatus.OK);
}
}