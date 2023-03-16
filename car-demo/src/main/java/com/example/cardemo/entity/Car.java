package com.example.cardemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.lang.model.element.Name;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Car extends IdClass{

    private String model;
    private String make;
    private int year;
    private int Millage;

    @OneToOne(mappedBy = "car", cascade = CascadeType.PERSIST)
    private CarManufacturer carManufacturer;

    @OneToOne(mappedBy = "car", cascade = CascadeType.PERSIST)
    @JoinTable(name = "car_insurance",
    joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "insurance_id", referencedColumnName = "id"))
    private InsuranceCompany insuranceCompany;

    @OneToMany(mappedBy = "car1", cascade = CascadeType.PERSIST)
    private List<Person> owners = new ArrayList<>();

    @OneToMany(mappedBy = "car2", cascade = CascadeType.PERSIST)
    private List<Person> drivers = new ArrayList<>();
    public Car() {
    }

    public Car(String model, String make, int year, int millage) {
        this.model = model;
        this.make = make;
        this.year = year;
        Millage = millage;
    }

    public void addOwner(Person person) {
        person.setCar1(this);
        owners.add(person);
    }

    public void addDriver(Person person) {
        person.setCar2(this);
        drivers.add(person);
    }
}
