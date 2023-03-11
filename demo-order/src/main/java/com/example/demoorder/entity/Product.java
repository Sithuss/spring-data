package com.example.demoorder.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
public class Product extends IdClass{

    @Column(length = 45)
    private String name;
    @Column(precision = 5, scale = 2)
    private BigDecimal price;
    private String description;
    private LocalDate lastUpdate;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
    private List<CustomerOrderHasProduct> customerOrderHasProducts;

    public Product(String name, double price, String description, LocalDate lastUpdate) {
        this.name = name;
        this.price = BigDecimal.valueOf(price);
        this.description = description;
        this.lastUpdate = lastUpdate;
    }

    public Product() {
    }

    public void addCohp(CustomerOrderHasProduct customerOrderHasProduct) {
        customerOrderHasProduct.setProduct(this);
//        this.customerOrderHasProducts.add(customerOrderHasProduct);
    }
}
