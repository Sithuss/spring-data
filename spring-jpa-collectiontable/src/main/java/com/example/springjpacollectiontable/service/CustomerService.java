package com.example.springjpacollectiontable.service;

import com.example.springjpacollectiontable.dao.CustomerDao;
import com.example.springjpacollectiontable.entity.Customer;
import com.example.springjpacollectiontable.entity.Phone;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

    private final CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Transactional
    public void createDb() {
        Customer customer1=new Customer("John Doe", "23232234");
        Customer customer2=new Customer("John William", "2322342");
        Customer customer3=new Customer("Thomas Hardy", "23224334");

        customer3.addAddress("Creed Bridge Road");
        customer3.addAddress("Dream Land");
        customer3.addAddress("Love Lane");
        customer3.addEmail("john@gmail.com");
        customer3.addEmail("doe@gmail.com");

        customer1.addPhoneNumber(new Phone("55-555-55", "MPT", "Apple"));
        customer1.addPhoneNumber(new Phone("66-66-666", "Ooredoo", "Sony"));
        customer1.addAddress("79 Pard Avenue");
        customer1.addAddress("11 Strand Road");
        customer1.addEmail("William@gmail.com");
        customer1.addEmail("Williamson@gmail.com");

        customer2.addEmail("Hardy@gmail.com");
        customer2.addEmail("Thomas@gmail.com");
        customer2.addAddress("blue Lagoon road");
        customer2.addAddress("sky blue creek");
        customer2.addPhoneNumber(new Phone("234234", "mpt", "Mi"));
        customer2.addPhoneNumber(new Phone("24325-234", "Telenor", "samsung"));

        customerDao.save(customer1);
        customerDao.save(customer2);
        customerDao.save(customer3);
    }
}
