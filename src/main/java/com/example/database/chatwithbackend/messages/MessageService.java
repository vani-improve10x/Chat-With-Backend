package com.example.database.chatwithbackend.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    messagesDbManager messagesDbManager;

    public List<Message> getTemplates(){
        return messagesDbManager.getTemplates();
    }
}
