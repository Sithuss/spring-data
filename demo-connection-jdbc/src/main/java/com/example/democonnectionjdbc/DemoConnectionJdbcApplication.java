package com.example.democonnectionjdbc;

import com.example.democonnectionjdbc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class DemoConnectionJdbcApplication implements CommandLineRunner{

    @Autowired
    private EmployeeService employeeService;
    @Override
    public void run(String... args) throws Exception {
        employeeService.createEmployeeWithTransaction();
    }

//    public CommandLineRunner runner(){
//        return r->{
//            employeeService.createEmployeeWithTransaction();
//        };
//    }

    public static void main(String[] args) {
        SpringApplication.run(DemoConnectionJdbcApplication.class, args);
    }


}
