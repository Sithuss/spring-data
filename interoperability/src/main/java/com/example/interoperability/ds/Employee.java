package com.example.interoperability.ds;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@Entity
@ToString
public class Employee {
    @Id
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String LastName;
    private String email;
    private double salary;

    public Employee(Integer id, String firstName, String lastName, String email, double salary) {
        this.id = id;
        this.firstName = firstName;
        LastName = lastName;
        this.email = email;
        this.salary = salary;
    }

    public Employee() {
    }
}
