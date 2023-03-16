package com.example.cardemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "insurance")
public class InsuranceCompany extends Company{

    private Integer rating;

    @OneToOne
    private Car car;

    public InsuranceCompany(String name, Address address, Integer rating) {
        super(name, address);
        this.rating = rating;
    }

    public InsuranceCompany() {
    }
}
