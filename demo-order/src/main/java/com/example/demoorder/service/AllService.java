package com.example.demoorder.service;

import com.example.demoorder.dao.CategoryDao;
import com.example.demoorder.dao.CustomerDao;
import com.example.demoorder.dao.CustomerOrderHasProductDao;
import com.example.demoorder.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class AllService {

    private final CategoryDao categoryDao;

    private final CustomerDao customerDao;

    private final CustomerOrderHasProductDao customerOrderHasProductDao;

    public AllService(CategoryDao categoryDao, CustomerDao customerDao, CustomerOrderHasProductDao customerOrderHasProductDao) {
        this.categoryDao = categoryDao;
        this.customerDao = customerDao;
        this.customerOrderHasProductDao = customerOrderHasProductDao;
    }

    @Transactional
    public void createDb() {
        Category category1 = new Category("drink");
        Category category2 = new Category("snack");

        Product product1 = new Product("coke", 600.00, "to drink", LocalDate.of(2022,12,30));
        Product product2 = new Product("potato chips", 500.00, "to eat", LocalDate.of(2023,2,28));

        Customer customer = new Customer("Harry Potter", "harry@gmail.com", "0923432", "Hogward", "Griffindor", "1234123");

        CustomerOrder customerOrder1 = new CustomerOrder(3.0, LocalDate.of(2023, 3, 10), 1231245);
        CustomerOrder customerOrder2 = new CustomerOrder(4.0, LocalDate.of(2023, 3, 10), 1233545);

        CustomerOrderHasProduct customerOrderHasProduct1 = new CustomerOrderHasProduct();
        CustomerOrderHasProduct customerOrderHasProduct2 = new CustomerOrderHasProduct();

        category1.addProduct(product1);
        category2.addProduct(product2);

        customer.addCustomerOrder(customerOrder1);
        customer.addCustomerOrder(customerOrder2);

//        customerOrderHasProduct1.setProduct(product1);
//        customerOrderHasProduct1.setCustomerOrder(customerOrder1);

        product1.addCohp(customerOrderHasProduct1);
        product2.addCohp(customerOrderHasProduct2);
        customerOrder1.addCohp(customerOrderHasProduct1);
        customerOrder2.addCohp(customerOrderHasProduct2);

        categoryDao.save(category1);
        categoryDao.save(category2);
        customerDao.save(customer);
        customerOrderHasProductDao.save(customerOrderHasProduct1);
        customerOrderHasProductDao.save(customerOrderHasProduct2);
    }
}
