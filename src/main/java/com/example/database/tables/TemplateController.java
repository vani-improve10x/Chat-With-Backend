package com.example.database.tables;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController("v2")

public class TemplateController {
    @GetMapping(value = "templateList", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Template> getTemplates(){
        List<Template> templates = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://db4free.net:3306/improve10x";
            String username = "trainee10x";
            String password = "12345678";
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Template");
            while (resultSet.next()){
                Template template = new Template();
                template.templateId = resultSet.getInt(1);
                 template.name = resultSet.getString(2);
                template.messageText = resultSet.getString(3);
                templates.add(template);
            }
            connection.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return templates;
    }
}
