package com.example.database.dbmanager.categoriesTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    DatabaseManager databaseManager;

    public List<String> getCategories(){
        return databaseManager.getCategories();
    }
}
