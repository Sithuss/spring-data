package com.example.cardemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@DiscriminatorValue("manufacturer")
@Table(name = "manufacturer")
public class CarManufacturer extends Company{

    private int numberOfEmployees;

    private int yearEstablished;

    @OneToOne
    private Car car;

    public CarManufacturer(String name, Address address, int numberOfEmployees, int yearEstablished) {
        super(name, address);
        this.numberOfEmployees = numberOfEmployees;
        this.yearEstablished = yearEstablished;
    }

    public CarManufacturer() {
    }
}

