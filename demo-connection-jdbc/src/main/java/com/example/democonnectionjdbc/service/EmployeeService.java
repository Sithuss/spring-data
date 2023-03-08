package com.example.democonnectionjdbc.service;

import com.example.democonnectionjdbc.dao.EmployeeDao;
import com.example.democonnectionjdbc.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Transactional
    public void createEmployeeWithTransaction() {

        employeeDao.createEmployee(new Employee(7, "Thuza", "Nwe", "nwe@gmail.com", 5000));
        employeeDao.createEmployee(new Employee(8, "Khaing", "Thuza", "haing@gmail.com", 7000));
        employeeDao.createEmployee(new Employee(9, "Thu Thu", "Thaw", "thuthu@gmail.com", 5000));
        employeeDao.createEmployee(new Employee(10, "Thaw Thaw", "Htun Zin", "thawthaw@gmail.com", 5000));
    }
}
