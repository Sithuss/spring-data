package com.example.demoorder.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Category extends IdClass {

    @Column(length = 45)
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
    private List<Product> products = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    public Category() {
    }

    public void addProduct(Product product) {
        product.setCategory(this);
        this.products.add(product);
    }
}
