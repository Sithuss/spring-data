package com.example.cardemo.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter
public class Address {
    private String street;
    private int streetNo;
    private String township;

    public Address(String street, int streetNo, String township) {
        this.street = street;
        this.streetNo = streetNo;
        this.township = township;
    }

    public Address() {
    }
}
