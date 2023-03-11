package com.example.zoodemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Cage extends IdClass{

    private String cageNo;
    private String location;

    @OneToOne
    private Animal animal;

    public Cage(String cageNo, String location) {
        this.cageNo = cageNo;
        this.location = location;
    }

    public Cage() {
    }
}


