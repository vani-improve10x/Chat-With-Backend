package com.example.database.tables;

import com.example.database.tables.Message;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController("s1")
public class MessageController {

    @GetMapping(value = "messageList", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Message> getMessages(){
        List<Message> messages = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://db4free.net:3306/improve10x";
            String username = "trainee10x";
            String password = "12345678";
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Message");
            while (resultSet.next()){
                Message message = new Message();
                message.messageId = resultSet.getInt(1);
                message.name = resultSet.getString(2);
                message.mobileNumber = resultSet.getString(3);
                message.messageText = resultSet.getString(4);
                messages.add(message);
            }
            connection.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return messages;
    }
}
