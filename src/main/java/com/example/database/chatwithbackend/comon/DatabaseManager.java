package com.example.database.chatwithbackend.comon;

import java.sql.*;

public abstract class DatabaseManager {
    protected Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://db4free.net:3306/improve10x";
        String username = "trainee10x";
        String password = "12345678";
        return DriverManager.getConnection(url, username, password);
    }

    protected Object runQuery(String query) throws SQLException, ClassNotFoundException {
        Connection connection = createConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        Object result = convertToObject(resultSet);
        connection.close();
        return result;
    }

    protected abstract Object convertToObject(ResultSet resultSet)throws SQLException;
}
