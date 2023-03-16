package com.example.demoorder;

import com.example.demoorder.service.AllService;
import com.example.demoorder.util.JPAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoOrderApplication implements CommandLineRunner {

    @Autowired
    private AllService allService;

    public static void main(String[] args) {
        SpringApplication.run(DemoOrderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        allService.createDb();

        JPAUtil.checkData("select * from category");
        JPAUtil.checkData("select * from product");
        JPAUtil.checkData("select * from customer");
        JPAUtil.checkData("select * from customer_order");
        JPAUtil.checkData("select * from customer_order_has_product");

    }
}
