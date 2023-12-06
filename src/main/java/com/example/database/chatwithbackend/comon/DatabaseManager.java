package com.example.database.chatwithbackend.comon;

import java.sql.*;
import java.util.List;

public abstract class DatabaseManager<T> {
    protected Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://db4free.net:3306/improve10x";
        String username = "trainee10x";
        String password = "12345678";
        return DriverManager.getConnection(url, username, password);
    }

    protected List<T> runQuery(String query) throws SQLException, ClassNotFoundException {
        Connection connection = createConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<T> result = convertToObject(resultSet);
        connection.close();
        return result;
    }

    protected abstract List<T> convertToObject(ResultSet resultSet)throws SQLException;
    protected int updateRunQuery(String query ) throws SQLException, ClassNotFoundException {
        int result;
        Connection connection = createConnection();
        Statement statement = connection.createStatement();
        result = statement.executeUpdate(query);
        connection.close();
        return result;
    }
//    protected abstract T convertToUpdateObject(ResultSet resultSet)throws SQLException;

}
