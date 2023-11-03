package com.example.database.dbmanager.templateTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateService {

    @Autowired
    DatabaseManager databaseManager;

    public List<Template> getTemplates(){
        return databaseManager.getTemplates();
    }
}
