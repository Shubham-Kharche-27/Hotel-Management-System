package com.hotel_management_system.dao;

import com.hotel_management_system.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Room {
    DbConnection dbConnect = new DbConnection();
    Connection connection;

    public Room() {
        connection = dbConnect.dbConnection();
        if (connection == null) {
            throw new RuntimeException("Failed to establish database connection");
        }
    }
    PreparedStatement preparedStatement;
    String query;
    int row = 0;
    ResultSet resultSet;
    public void roomDaoCreate(int room_number, String room_type, double price, String status) throws SQLException {
        query = "INSERT INTO rooms(room_number,room_type,price,status) VALUES(?,?,?,?)";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, room_number);
        preparedStatement.setString(2, room_type);
        preparedStatement.setDouble(3, price);
        preparedStatement.setString(4, status);
        row = preparedStatement.executeUpdate();
        if (row > 0) {
            System.out.println("Room added succesfully.");
        } else {
            System.out.println("Room not added.");
        }
        preparedStatement.close();
        connection.close();
    }

    public void roomDaoRead() throws SQLException {
        query = "SELECT * FROM rooms";
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
        System.out.println("+---------+-------------+------------+----------+----------+");
        System.out.printf("| %-7s | %-11s | %-10s | %-8s | %-8s |\n",
                "room_id", "room_number", "room_type", "price", "status");
        System.out.println("+---------+-------------+------------+----------+----------+");
        while (resultSet.next()) {
            System.out.printf("| %-7d | %-11d | %-10s | %-8.2f | %-8s |\n", resultSet.getInt("room_id"), resultSet.getInt("room_number"), resultSet.getString("room_type"), resultSet.getDouble("price"), resultSet.getString("status"));
            System.out.println("+---------+-------------+------------+----------+----------+");

        }
        preparedStatement.close();
        connection.close();
    }

    public void roomDaoUpdate(int room_id,int room_number, String room_type, double price, String status) throws SQLException {
        query = "UPDATE rooms SET room_number = ?,room_type = ?,price = ?,status = ? WHERE room_id =?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, room_number);
        preparedStatement.setString(2, room_type);
        preparedStatement.setDouble(3, price);
        preparedStatement.setString(4, status);
        preparedStatement.setInt(5,room_id);
        row = preparedStatement.executeUpdate();
        if (row > 0) {
            System.out.println("Room updated Successfully");
        } else {
            System.out.println("Room not updated.");
        }
        preparedStatement.close();
        connection.close();

    }

    public void roomDaoDelete(int room_id) throws SQLException {
        query = "DELETE FROM rooms WHERE room_id = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, room_id);
        row = preparedStatement.executeUpdate();
        if (row > 0) {
            System.out.println("Room was deleted.");
        } else {
            System.out.println("Room was not deleted.");
        }
        preparedStatement.close();
        connection.close();
    }
}