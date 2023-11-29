package com.example.database.chatwithbackend.templates;

import com.example.database.chatwithbackend.comon.DatabaseManager;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service("d1")
public class templatesDbManager extends DatabaseManager {
    public List<Template> getTemplates() {
        try {
            List<Template> templates = (List<Template>) runQuery("select * from Template");
            return templates;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }



    @Override
    protected Object convertToObject(ResultSet resultSet) throws SQLException{
        List<Template> templates = new ArrayList<>();
        while (resultSet.next()) {
            Template template = new Template();
            template.templateId = resultSet.getInt(1);
            template.name = resultSet.getString(2);
            template.messageText = resultSet.getString(3);
            templates.add(template);
        }
        return templates;
    }
}
