package com.example.zoodemo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class FoodItem extends IdClass {

    private String name;
    private Integer quantity;

    @ManyToMany
    private List<Animal> animals = new ArrayList<>();

    @ManyToOne
    private Supplier supplier;


    public FoodItem(String name, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public FoodItem() {
    }

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }
}
