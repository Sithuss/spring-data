package com.example.zoodemo.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Supplier extends IdClass {

    private String supplier_name;
    private String contactNo;
    private String address;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.PERSIST)
    private List<FoodItem> foodItems = new ArrayList<>();

    public Supplier(String supplier_name, String contactNo, String address) {
        this.supplier_name = supplier_name;
        this.contactNo = contactNo;
        this.address = address;
    }

    public Supplier() {
    }

    public void addFoodItem(FoodItem foodItem) {
        foodItem.setSupplier(this);
        this.foodItems.add(foodItem);
    }
}
