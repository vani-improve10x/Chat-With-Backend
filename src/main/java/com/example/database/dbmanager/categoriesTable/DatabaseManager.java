package com.example.database.dbmanager.categoriesTable;

import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service("d3")
public class DatabaseManager {

    public List<String> getCategories(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://db4free.net:3306/improve10x";
            String username = "trainee10x";
            String password = "12345678";
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Categories");
            List<String> categories = new ArrayList<>();
            while (resultSet.next()){
                String name = resultSet.getString(1);
                categories.add(name);
            }
            connection.close();
            return categories;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
