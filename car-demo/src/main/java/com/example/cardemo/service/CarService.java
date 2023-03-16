package com.example.cardemo.service;

import com.example.cardemo.dao.CarDao;
import com.example.cardemo.dao.CarManufacturerDao;
import com.example.cardemo.dao.InsurenceCompanyDao;
import com.example.cardemo.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class CarService {

    private final CarDao carDao;
    private final CarManufacturerDao carManufacturerDao;
    private final InsurenceCompanyDao insurenceCompanyDao;


    public CarService(CarDao carDao, CarManufacturerDao carManufacturerDao, InsurenceCompanyDao insurenceCompanyDao) {
        this.carDao = carDao;
        this.carManufacturerDao = carManufacturerDao;
        this.insurenceCompanyDao = insurenceCompanyDao;
    }

    @Transactional
    public void createDb() {
        Car car1 = new Car("Honda", "japan", 2004, 30);
        Car car2 = new Car("zuzuki", "japan", 2007, 60);
        Car car3 = new Car("weaver", "Laos", 2003, 70);

        CarManufacturer carManufacturer1 = new CarManufacturer("Dyna", new Address("Saint Road", 25, "raccon"), 100, 1996);
        CarManufacturer carManufacturer2 = new CarManufacturer("Logan", new Address("Peterson", 23, "ancient"), 100, 1986);
        CarManufacturer carManufacturer3 = new CarManufacturer("Walter", new Address("Creed Bridge", 25, "Kyoto"), 100, 1976);

        InsuranceCompany insuranceCompany1 = new InsuranceCompany("semmetary", new Address("Grave yard Street", 50, "hell"), 8);
        InsuranceCompany insuranceCompany2 = new InsuranceCompany("funeral parlor", new Address("Grave yard Road", 99, "hell"), 8);

        Person person1 = new Person("Harry Potter", LocalDate.of(1995, 06, 19));
        Person person2 = new Person("Ron", LocalDate.of(1994, 07, 20));

        Person person3 = new Person("Larry", LocalDate.of(2000, 8, 14));
        Person person4 = new Person("Donal", LocalDate.of(2001, 8, 14));


        car1.setCarManufacturer(carManufacturer1);
        carManufacturer1.setCar(car1);
        car2.setCarManufacturer(carManufacturer2);
        carManufacturer2.setCar(car2);
        car3.setCarManufacturer(carManufacturer3);
        carManufacturer3.setCar(car3);


        insuranceCompany1.setCar(car1);
        car1.setInsuranceCompany(insuranceCompany1);
        insuranceCompany2.setCar(car2);
        car2.setInsuranceCompany(insuranceCompany2);

        car1.addDriver(person1);
        car1.addDriver(person2);

        car1.addOwner(person1);
        car2.addOwner(person2);
        car3.addOwner(person3);
        car2.addOwner(person4);

        carDao.save(car1);
        carDao.save(car2);
        carDao.save(car3);

//        carManufacturerDao.save(carManufacturer1);
//        carManufacturerDao.save(carManufacturer2);
//        carManufacturerDao.save(carManufacturer3);
//
//        insurenceCompanyDao.save(insuranceCompany1);
//        insurenceCompanyDao.save(insuranceCompany2);

    }
}
