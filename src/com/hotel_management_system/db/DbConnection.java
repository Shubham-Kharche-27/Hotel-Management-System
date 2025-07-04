package com.hotel_management_system.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static final String url = "jdbc:mysql://127.0.0.1:3306/hotel_management_system";
    private static final String username = "root";
    private static final String password = "Pass@123";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found", e);
        }
    }

    public Connection dbConnection() {
        try {
            return DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database:");
            e.printStackTrace();
            return null;
        }
    }
}
