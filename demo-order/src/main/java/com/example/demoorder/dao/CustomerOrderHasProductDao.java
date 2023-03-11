package com.example.demoorder.dao;

import com.example.demoorder.entity.CustomerOrderHasProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderHasProductDao extends JpaRepository<CustomerOrderHasProduct, Integer> {
}
