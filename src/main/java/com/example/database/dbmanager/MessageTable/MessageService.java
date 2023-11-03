package com.example.database.dbmanager.MessageTable;

import com.example.database.dbmanager.MessageTable.DatabaseManager;
import com.example.database.dbmanager.MessageTable.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    DatabaseManager databaseManager;

    public List<Message> getTemplates(){
        return databaseManager.getTemplates();
    }
}
