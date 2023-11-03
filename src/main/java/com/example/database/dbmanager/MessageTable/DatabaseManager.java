package com.example.database.dbmanager.MessageTable;

import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service("d2")
public class DatabaseManager {

    public List<Message> getTemplates(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://db4free.net:3306/improve10x";
            String username = "trainee10x";
            String password = "12345678";
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Message");
            List<Message> messages = new ArrayList<>();
            while (resultSet.next()){
                Message message = new Message();
                message.messageId = resultSet.getInt(1);
                message.name = resultSet.getString(2);
                message.mobileNumber = resultSet.getString(3);
                message.messageText = resultSet.getString(4);
                messages.add(message);
            }
            connection.close();
            return messages;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
