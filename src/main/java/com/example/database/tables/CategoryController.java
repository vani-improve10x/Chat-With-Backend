package com.example.database.tables;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController("r1")
public class CategoryController {

    @GetMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getCategories() {
        List<String> categoryList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://db4free.net:3306/improve10x";
            String username = "trainee10x";
            String password = "12345678";
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Categories");
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                categoryList.add(name);
            }
            connection.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categoryList;
    }
}
