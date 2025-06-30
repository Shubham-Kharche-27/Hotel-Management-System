package com.hotel_management_system.dao;

import com.hotel_management_system.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Room {
    public void roomDao(int room_number, String room_type , double price ,String status,int choice) throws ClassNotFoundException, SQLException {
        switch(choice){
            case 1:
                DbConnection dbConnect = new DbConnection();
                Connection connection = dbConnect.dbConnection();
                PreparedStatement preparedStatement;
                String query;
                int row = 0;
                ResultSet resultSet;

                switch(choice){
                    case 1:
                        query = "INSERT INTO rooms(room_number,room_type,price,status) VALUES(?,?,?,?)";
                        preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setInt(1,room_number);
                        preparedStatement.setString(2,room_type);
                        preparedStatement.setDouble(3,price);
                        preparedStatement.setString(4,status);
                        row = preparedStatement.executeUpdate();
                        if(row>0){
                            System.out.println("Room added succesfully.");
                        }else{
                            System.out.println("Room not added.");
                        }

                    case 2:
                        query = "SELECT * FROM rooms";
                        preparedStatement = connection.prepareStatement(query);
                        resultSet = preparedStatement.executeQuery();
                        while(resultSet.next()){
                            System.out.println("+---------+-------------+------------+----------+----------+");
                            System.out.printf("| %-7s | %-11s | %-10s | %-8s | %-8s |\n",
                                    "room_id", "room_number", "room_type", "price", "status");
                            System.out.println("+---------+-------------+------------+----------+----------+");
                            System.out.printf("| %-7d | %-11d | %-10s | %-8.2f | %-8s |\n", resultSet.getInt("room_id"), resultSet.getInt("room_number"), resultSet.getString("room_type"), resultSet.getDouble("price"), resultSet.getString("status"));

                        }

                    case 3:
                        query = "INSERT INTO rooms SET room_number = ?,room_type = ?,price = ?,status = ? WHERE room_id =?";

                }
        }
    }
}
