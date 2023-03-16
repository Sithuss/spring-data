package com.demo.service;

import com.demo.dao.EmployeeDao;
import com.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> listAllEmployee() {
        return employeeDao.findAll();
    }

    @Transactional
    public void createDb() {
        Employee e1 = new Employee(1,"John", "Doe", "john@gmail.com", 3000);
        Employee e2 = new Employee(2,"John", "Will", "will@gmail.com", 4000);
        Employee e3 = new Employee(3,"Harry", "Potter", "potter@gmail.com", 5000);

        employeeDao.save(e1);
        employeeDao.save(e2);
        employeeDao.save(e3);
    }
}
