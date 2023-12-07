package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Property")
public class Property {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@Column(name = "address", nullable = false)
private String address;


@Column(name = "price", nullable = false)
private double price;

public Property() {
}

public Property(long id, String address, double price) {
    this.id = id;
    this.address = address;
    this.price = price;
}


public long getId() {
    return id;
}

public void setId(long id) {
    this.id = id;
}

public String getAddress() {
    return address;
}

public void setAddress(String address) {
    this.address = address;
}

public double getPrice() {
    return price;
}

public void setPrice(double price) {
    this.price = price;
}





}
