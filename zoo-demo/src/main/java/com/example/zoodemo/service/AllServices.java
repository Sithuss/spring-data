package com.example.zoodemo.service;

import com.example.zoodemo.dao.*;
import com.example.zoodemo.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AllServices {
    private final AnimalDao animalDao;
    private final CageDao cageDao;
    private final CategoryDao categoryDao;
    private final FoodItemDao foodItemDao;
    private final SupplierDao supplierDao;

    public AllServices(AnimalDao animalDao, CageDao cageDao, CategoryDao categoryDao, FoodItemDao foodItemDao, SupplierDao supplierDao) {
        this.animalDao = animalDao;
        this.cageDao = cageDao;
        this.categoryDao = categoryDao;
        this.foodItemDao = foodItemDao;
        this.supplierDao = supplierDao;
    }

    @Transactional
    public void addAll() {
        Animal animal1 = new Animal("monkey", 4);
        Animal animal2 = new Animal("elephant", 5);
        Animal animal3 = new Animal("tiger", 2);

        Cage cage1 = new Cage("o1b", "north");
        Cage cage2 = new Cage("o14", "north-east");
        Cage cage3 = new Cage("11b", "south");

        cage1.setAnimal(animal1);
        animal1.setCage(cage1);
        cage2.setAnimal(animal2);
        animal2.setCage(cage2);
        cage3.setAnimal(animal3);
        animal3.setCage(cage3);

        Category category = new Category("can eat.");

        category.addAnimal(animal1);
        category.addAnimal(animal2);
        category.addAnimal(animal3);

        FoodItem foodItem1 = new FoodItem("banana", 30);
        FoodItem foodItem2 = new FoodItem("sugar cane", 60);
        FoodItem foodItem3 = new FoodItem("meat 100g. ", 50);

        foodItem1.addAnimal(animal1);
        foodItem2.addAnimal(animal2);
        foodItem3.addAnimal(animal3);

        foodItem1.addAnimal(animal2);
        foodItem3.addAnimal(animal1);

        Supplier supplier = new Supplier("John", "34123423", "Yangon");
        supplier.addFoodItem(foodItem1);
        supplier.addFoodItem(foodItem2);
        supplier.addFoodItem(foodItem3);
        //Map
        cageDao.save(cage1);
        cageDao.save(cage2);
        cageDao.save(cage3);

        categoryDao.save(category);



        supplierDao.save(supplier);
    }
}
