package com.example.database.chatwithbackend.templates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("v1")
@RequestMapping("v1")  // in browser base url after we will write v1/templates
public class TemplateController {

    @Autowired
    TemplateService templateService;

    @GetMapping(value = "templates",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Template> getTemplates(){
        return templateService.getTemplates();
    }

    @PutMapping(value = "templates/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateTemplate(@PathVariable("id") int templateId, @RequestParam String messageText){
        templateService.updateTemplate(templateId,messageText);
    }
}
