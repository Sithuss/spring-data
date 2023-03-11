package com.example.demoorder.entity;

import jakarta.persistence.*;
import lombok.Data;

@MappedSuperclass
@Data
public class IdClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
