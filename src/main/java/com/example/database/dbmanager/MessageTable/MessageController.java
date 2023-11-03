package com.example.database.dbmanager.MessageTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("s2")
public class MessageController {

    @Autowired
    MessageService messageService;

    @GetMapping(value = "messages",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Message> getMessages(){
        return messageService.getTemplates();
    }
}
