package com.example.demoorder.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class CustomerOrderHasProduct extends IdClass {

    @ManyToOne
    private Product product;

    @ManyToOne
    private CustomerOrder customerOrder;

}
