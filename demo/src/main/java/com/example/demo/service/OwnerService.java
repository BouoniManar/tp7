package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Owner;

public interface OwnerService {
Owner saveOwner(Owner owner);
List<Owner> getAllOwner();
Owner getOwnerById(long id);
Owner updateOwner(Owner owner, long id);
void deleteOwner(long id);
}