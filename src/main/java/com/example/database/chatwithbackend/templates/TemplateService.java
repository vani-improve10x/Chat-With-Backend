package com.example.database.chatwithbackend.templates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TemplateService {
    List<Template> templates = new ArrayList<>();

    @Autowired
    templatesDbManager templatesDbManager;

    public List<Template> getTemplates(){
        return templatesDbManager.getTemplates();
    }

    public void updateTemplate(int templateId, String messageText){
        templatesDbManager.updateTemplate(templateId,messageText);
    }
}
