package com.example.demo.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Owner;

@Service
public interface OwnerService {
    List<Owner> getAllOwners();
    Owner getOwnerById(Long id);
    Owner saveOwner(Owner owner);
    Owner updateOwner(Long id, Owner owner);
    void deleteOwner(Long id);
}


