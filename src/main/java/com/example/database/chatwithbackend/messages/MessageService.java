package com.example.database.chatwithbackend.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    messagesDbManager messagesDbManager;

    public List<Message> getMessages() {
        return messagesDbManager.getMessages();
    }

    public int updateMessage(int messageId, String name) {
        return messagesDbManager.updateMessages(messageId, name);
    }

    public int updatedMessage(int messageId, String name, String mobileNumber){
        return messagesDbManager.updatedMessage(messageId,name,mobileNumber);
    }

    public void deletedMessage(int messageId){
        messagesDbManager.deletedMessage(messageId);
    }
}
