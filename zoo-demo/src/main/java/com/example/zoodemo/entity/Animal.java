package com.example.zoodemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Animal extends IdClass{

    private String type;
    private Integer totalNo;

    @OneToOne(mappedBy = "animal", cascade = CascadeType.PERSIST)
    private Cage cage;

    @ManyToOne
    private Category category;

    @ManyToMany(mappedBy = "animals")
    private List<FoodItem> foodItems = new ArrayList<>();

    public Animal(String type, Integer totalNo) {
        this.type = type;
        this.totalNo = totalNo;
    }

    public Animal() {
    }

    private void addFoodItem(FoodItem foodItem) {
        foodItem.getAnimals().add(this);
        this.foodItems.add(foodItem);
    }
}
