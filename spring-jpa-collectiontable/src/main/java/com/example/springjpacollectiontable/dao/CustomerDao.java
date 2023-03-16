package com.example.springjpacollectiontable.dao;

import com.example.springjpacollectiontable.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Integer> {
}
