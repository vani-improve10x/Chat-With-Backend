package com.example.database.chatwithbackend.templates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateService {

    @Autowired
    templatesDbManager templatesDbManager;

    public List<Template> getTemplates(){
        return templatesDbManager.getTemplates();
    }
}
