package com.example.cardemo.dao;

import com.example.cardemo.entity.InsuranceCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsurenceCompanyDao extends JpaRepository<InsuranceCompany, Integer> {
}
