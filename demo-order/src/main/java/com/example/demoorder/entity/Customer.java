package com.example.demoorder.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Customer extends IdClass{

    @Column(length = 45)
    private String name;
    @Column(length = 45)
    private String email;
    @Column(length = 45)
    private String phone;
    @Column(length = 45)
    private String address;
    private String cityRegion;
    @Column(length = 19)
    private String ccNumber;


    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    private List<CustomerOrder> customerOrders = new ArrayList<>();

    public Customer(String name, String email, String phone, String address, String cityRegion, String ccNumber) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.cityRegion = cityRegion;
        this.ccNumber = ccNumber;
    }

    public Customer() {
    }

    public void addCustomerOrder(CustomerOrder customerOrder) {
        customerOrder.setCustomer(this);
        this.customerOrders.add(customerOrder);
    }
}
