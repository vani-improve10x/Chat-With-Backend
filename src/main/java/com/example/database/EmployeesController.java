package com.example.database;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeesController {

    @GetMapping(value = "totalData/{salary}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getAllData(@PathVariable("salary") float salary, @PathVariable("salary") float salary1){
        List<Employee> employeeList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://db4free.net:3306/improve10x";
            String username = "trainee10x";
            String password = "12345678";
            Connection connection = DriverManager
                    .getConnection(url,username,password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee where salary between 50000.00 and 60000.00 ");
            while (resultSet.next()){
                Employee employee = new Employee();
                employee.employeeId = resultSet.getInt(1);
                employee.firstName = resultSet.getString(2);
                employee.lastName = resultSet.getString(3);
                employee.email = resultSet.getString(4);
                employee.hireDate = resultSet.getString(5);
                employee.salary = resultSet.getFloat(6);
                employeeList.add(employee);
            }
            connection.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeeList;
    }
}
