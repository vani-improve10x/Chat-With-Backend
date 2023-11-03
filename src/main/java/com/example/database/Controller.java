package com.example.database;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@RestController
public class Controller {

    @GetMapping(value = "studentNames/major",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getStudentNames(@RequestParam String major){
        List<String> studentNames = new ArrayList<>();
        /*
        Get all the details with respect to database
        URL : jdbc:mysql://db4free.net:3306
        Database Name: improve 10x
        Username : trainee10x
        password : 12345678
        get the Library to sql
        use the necessary classes to connect with database
        create Query and execute
        get the response and use it
        disconnect with database
         */
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://db4free.net:3306/improve10x";
            String username = "trainee10x";
            String password = "12345678";
            Connection connection = DriverManager
                    .getConnection(url,username,password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student where major ="+major);
            while (resultSet.next()){
                String firstname = resultSet.getString(2);
                String lastname = resultSet.getString(3);
                studentNames.add(firstname + " " + lastname);
            }
            connection.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentNames;
    }
}
