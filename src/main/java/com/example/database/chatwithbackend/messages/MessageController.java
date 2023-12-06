package com.example.database.chatwithbackend.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("m1")
@RequestMapping("m1")
public class MessageController {

    @Autowired
    MessageService messageService;

    @GetMapping(value = "listOfMessages",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Message> getMessages(){
        return messageService.getMessages();
    }

    @PutMapping(value = "listOfMessages/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public int updateMessage(@PathVariable("id") int  messageId, @RequestParam String name){
        return messageService.updateMessage(messageId,name);
    }

    @PutMapping(value = "listOfMessages/{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public int updatedMessage(@PathVariable("id") int messageId, @RequestParam String name,@RequestParam String mobileNumber){
        return messageService.updatedMessage(messageId,name,mobileNumber);
    }
}