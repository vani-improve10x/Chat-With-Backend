package com.example.database;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@RestController
public class EmployeeController {
    @GetMapping(value = "person/{employeeId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getEmployeeNames(@PathVariable("employeeId") int employeeId){
        List<String> employeeNames = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://db4free.net:3306/improve10x";
            String username = "trainee10x";
            String password = "12345678";
            Connection connection = DriverManager
                    .getConnection(url,username,password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee where employee_id = " + employeeId);
            while (resultSet.next()){
                String email = resultSet.getString(4);
                employeeNames.add(email);
            }
            connection.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeeNames;
    }
}
