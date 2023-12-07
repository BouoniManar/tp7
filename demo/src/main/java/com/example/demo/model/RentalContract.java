package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="RentalContract")
public class RentalContract {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@ManyToOne
    private Property property;

    @ManyToOne
    private Owner owner;

@Column(name = "tenant", nullable = false)
private String tenant;


@Column(name = "monthlyRent", nullable = false)
private double monthlyRent;

public RentalContract() {
}

public RentalContract(long id, Property property, Owner owner, String tenant, double monthlyRent) {
    this.id = id;
    this.property = property;
    this.owner = owner;
    this.tenant = tenant;
    this.monthlyRent = monthlyRent;
}

public long getId() {
    return id;
}

public void setId(long id) {
    this.id = id;
}

public Property getProperty() {
    return property;
}

public void setProperty(Property property) {
    this.property = property;
}

public Owner getOwner() {
    return owner;
}

public void setOwner(Owner owner) {
    this.owner = owner;
}

public String getTenant() {
    return tenant;
}

public void setTenant(String tenant) {
    this.tenant = tenant;
}

public double getMonthlyRent() {
    return monthlyRent;
}

public void setMonthlyRent(double monthlyRent) {
    this.monthlyRent = monthlyRent;
}

}
