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
@Table(name="Owner")
public class Owner {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@Column(name = "name", nullable = false)
private String name;

@Column(name = "contactInformation", nullable = false)
private String contactInformation;


public Owner() {
}

public Owner(long id, String name, String contactInformation) {
    this.id = id;
    this.name = name;
    this.contactInformation = contactInformation;
}

public long getId() {
    return id;
}

public void setId(long id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getContactInformation() {
    return contactInformation;
}

public void setContactInformation(String contactInformation) {
    this.contactInformation = contactInformation;
}

}