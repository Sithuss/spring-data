package com.example.manytomanydemo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@MappedSuperclass
@Data
public class IdClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
