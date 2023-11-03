package com.example.database;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentsController {

    @GetMapping(value = "list/studentId",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getTheData(@RequestParam int studentId){
        List<Student> studentList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://db4free.net:3306/improve10x";
            String username = "trainee10x";
            String password = "12345678";
            Connection connection = DriverManager
                    .getConnection(url,username,password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM  student where student_id = " + studentId);
            while (resultSet.next()){
                Student student = new Student();
                student.studentId = resultSet.getInt(1);
                student.firstName = resultSet.getString(2);
                student.lastName = resultSet.getString(3);
                student.dateOfBirth = resultSet.getString(4);
                student.email = resultSet.getString(5);
                student.major = resultSet.getString(6);
                student.graduationYear = resultSet.getInt(7);
                studentList.add(student);
            }
            connection.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }
}
