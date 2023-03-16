package com.example.democonnectionjdbc.ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Employee {
    private int id;
    private String first_name;

    private String last_name;
    private String email;
    private double salary;
}
