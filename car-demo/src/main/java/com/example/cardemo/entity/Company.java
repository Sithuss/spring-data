package com.example.cardemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "company_type")
public abstract class Company extends IdClass{
    private String name;
    @Embedded
    private Address address;

    public Company(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Company() {
    }
}
