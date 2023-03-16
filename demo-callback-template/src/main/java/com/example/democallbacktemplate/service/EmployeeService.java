package com.example.democallbacktemplate.service;

import com.example.ds.Employee;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public double avgModernWay() {
        return jdbcTemplate.query("select * from employee", this::mapEmployee)
                .stream()
                .map(Employee::getSalary).mapToDouble(s -> s)
                .average().orElse(0);
    }

    public double avgNativeWay() {
        return jdbcTemplate.queryForObject("""
                select avg(salary) from employee
                """, Double.class);
    }

    public void createEmployee(Employee emp) {
        jdbcTemplate.update("""
                    insert into employee(id, first_name, last_name, email, salary)
                    values (?,?,?,?,?)
                """, emp.getId(), emp.getFirst_name(), emp.getLast_name(), emp.getEmail(), emp.getSalary());
    }

    public Employee findEmployeeByEmail(String email) {
        return jdbcTemplate.query(new PreparedStatementCreator() {
                                      @Override
                                      public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                          return con.prepareStatement("select * from employee where email = ?");
                                      }
                                  },
                new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps) throws SQLException {
                        ps.setString(1, email);
                    }
                },
                new ResultSetExtractor<Employee>() {
                    @Override
                    public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
                        Employee e = null;
                        while (rs.next()) {
                            e = new Employee(
                                    rs.getInt("id"),
                                    rs.getString("first_name"),
                                    rs.getString("last_name"),
                                    rs.getString("email"),
                                    rs.getDouble("salary")
                            );
                        }
                        return e;
                    }
                }
        );

    }

    public List<Employee> listAllEmployee() {
        return jdbcTemplate.query("select * from employee",
                this::mapEmployee
        );
    }

    public double avgRollCallbackHandler() {
        CustomRowCallbackHandler rowCallbackHandler = new CustomRowCallbackHandler();

        jdbcTemplate.query("""
                select salary from employee
                """, rowCallbackHandler);

        return rowCallbackHandler.averageSalary();
    }

    public double avgResultExtractor() {
        CustomResultExtractor resultExtractor = new CustomResultExtractor();
        return jdbcTemplate.query("select salary from employee", resultExtractor);
    }

    @SneakyThrows
    private Employee mapEmployee(ResultSet rs, int i) {
        return new Employee(
                rs.getInt("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                rs.getDouble("salary")
        );
    }

    class CustomResultExtractor implements ResultSetExtractor<Double> {

        @Override
        public Double extractData(ResultSet rs) throws SQLException, DataAccessException {
            double total = 0;
            int count = 0;
            while (rs.next()) {
                total += rs.getDouble("salary");
                count++;
            }
            return total / count;

        }
    }

    class CustomRowCallbackHandler implements RowCallbackHandler {

        double total;
        int count;

        @Override
        public void processRow(ResultSet rs) throws SQLException {
            total += rs.getDouble("salary");
            count++;
        }

        public double averageSalary() {
            return total / count;
        }
    }


}
