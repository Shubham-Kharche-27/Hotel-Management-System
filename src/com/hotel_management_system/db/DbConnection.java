package com.hotel_management_system.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static final String url = "jdbc:mysql://127.0.0.1:3306/hotel_management_system";
    private static final String username = "root";
    private static final String password = "Pass@123";

    public Connection dbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url,username,password);
        return connection;
    }

}
