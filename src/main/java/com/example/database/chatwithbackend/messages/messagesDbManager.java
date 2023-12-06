package com.example.database.chatwithbackend.messages;

import com.example.database.chatwithbackend.comon.DatabaseManager;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service("d2")
public class messagesDbManager extends DatabaseManager<Message> {

    public List<Message> getMessages() {
        try {
            List<Message> messageList = runQuery("select * from Message");
            return messageList;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected List<Message> convertToObject(ResultSet resultSet) throws SQLException{
        List<Message> messageList = new ArrayList<>();
        while (resultSet.next()) {
            Message message = new Message();
            message.messageId = resultSet.getInt(1);
            message.name = resultSet.getString(2);
            message.mobileNumber = resultSet.getString(3);
            message.messageText = resultSet.getString(4);
            messageList.add(message);
        }
        return messageList;
    }


    public int updateMessages(int messageId, String name) {
        try {
             int result = updateRunQuery("update Message set name = '"+name+"' where messageId = "+messageId+" ;");
             return result;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
