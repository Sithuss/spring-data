package com.example.democallbacktemplate;

import com.example.democallbacktemplate.service.EmployeeService;
import com.example.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoCallbackTemplateApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;
    public static void main(String[] args) {
        SpringApplication.run(DemoCallbackTemplateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        employeeService.listAllEmployee().forEach(System.out::println);

        System.out.println("Average Salary:: " + employeeService.avgResultExtractor());

        System.out.println("Find by email:: " + employeeService.findEmployeeByEmail("richard@gmail.com"));
        System.out.println();

        employeeService.createEmployee(new Employee(
                7, "Thuzar", "nwe", "thuzarnew@gmal.com", 8000
        ));
        employeeService.listAllEmployee().forEach(System.out::println);

        System.out.println("Avg native way:: "+ employeeService.avgNativeWay());

        System.out.println("Avg Modern way :: " + employeeService.avgModernWay());
    }
}
