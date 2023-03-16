package com.example.singleworkunit.service;

import com.example.singleworkunit.dao.EmployeeDao;
import com.example.singleworkunit.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

//    @Transactional()
    public void createEmployeeWithTransaction()  {
        createEmployees();

    }

    public void createEmployeeWithoutTransaction()  {
        createEmployees();
    }

    public void deleteALlEmployee(){
        employeeDao.deleteAllEmployee();
    }
    public List<Employee> listAllEmployee() {
        return employeeDao.listAllEmployee();
    }

    private void createEmployees() {
        employeeDao.createEmployee(new Employee(12, "Thuza", "Nwe", "nwe@gmail.com", 5000));
        employeeDao.createEmployee(new Employee(13, "Khaing", "Thuza", "haing@gmail.com", 7000));
        employeeDao.createEmployee(new Employee(-14, "Thu Thu", "Thaw", "thuthu@gmail.com", 5000));
        employeeDao.createEmployee(new Employee(15, "Thaw Thaw", "Htun Zin", "thawthaw@gmail.com", 5000));
    }
}
