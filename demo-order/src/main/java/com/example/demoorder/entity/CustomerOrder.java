package com.example.demoorder.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
public class CustomerOrder extends IdClass {

    @Column(precision = 8, scale = 2)
    private BigDecimal amount;
    private LocalDate dateCreated;

    private Integer confirmationNumber;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "customerOrder", cascade = CascadeType.PERSIST)
    private List<CustomerOrderHasProduct> customerOrderHasProducts;

    public CustomerOrder(double amount, LocalDate dateCreated, Integer confirmationNumber) {
        this.amount = BigDecimal.valueOf(amount);
        this.dateCreated = dateCreated;
        this.confirmationNumber = confirmationNumber;
    }

    public CustomerOrder() {
    }

    public void addCohp(CustomerOrderHasProduct customerOrderHasProduct) {
        customerOrderHasProduct.setCustomerOrder(this);
//        this.customerOrderHasProducts.add(customerOrderHasProduct);
    }
}
