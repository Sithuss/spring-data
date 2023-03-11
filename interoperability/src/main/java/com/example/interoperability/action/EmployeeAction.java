package com.example.interoperability.action;

import com.example.interoperability.ds.Employee;
import com.example.interoperability.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeAction {
    @Autowired
    private EmployeeService employeeService;

    public void deleteEmployee() {
        employeeService.deleteAll();
    }

    public Iterable<Employee> findAll() {
        return employeeService.listEmployee();
    }

    @Transactional
    public void createEmployee() {
        employeeService.createEmployeeWithJdbc(1,"John", "doe", "john@gmail.com", 10000);
        employeeService.createEmployeeWithJdbc(2,"Thomas", "Hardy", "thomas@gmail.com", 10000);
        employeeService.createEmployeeWithJpa(new Employee(3,"Richard", "Chan", "richard@gmail.com", 10000));
        employeeService.createEmployeeWithJdbc(4,"Angel", "Chan", "chann@gmail.com", 10000);

        throw new RuntimeException();

    }


}
