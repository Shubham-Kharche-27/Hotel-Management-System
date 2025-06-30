package com.hotel_management_system.dao;

import com.hotel_management_system.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Guest {
    public void GuestDao(int guest_id,String name,String phone,String email,int choice) throws ClassNotFoundException, SQLException,InterruptedException {
        DbConnection dbConnect= new DbConnection();
        Connection connection = dbConnect.dbConnection();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String query;
        int row = 0;
        switch(choice){
            case 1:
                query = "INSERT INTO guests(guest_id,name,phone,email) VALUES(?,?,?,?)";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1,guest_id);
                preparedStatement.setString(2,name);
                preparedStatement.setString(3,phone);
                preparedStatement.setString(4,email);
                row = preparedStatement.executeUpdate();
                Thread.sleep(2000);
                if(row>0){
                    System.out.println("Guest was Added Successfully.");
                }
                else{
                    System.out.println("Guest cannot added.");
                }

            case 2:
                query = "SELECT * FROM guests";
                preparedStatement = connection.prepareStatement(query);
                resultSet = preparedStatement.executeQuery();
                if(resultSet.next()){
                    System.out.println("+----------+--------------+----------------------+----------------+");
                    System.out.printf("| %-8s | %-12s | %-20s | %-14s |\n", "guest_id", "name", "phone", "email");
                    System.out.println("+----------+--------------+----------------------+----------------+");
                    System.out.printf("| %-8s | %-12s | %-20s | %-14s |\n", resultSet.getInt(guest_id), resultSet.getString(name), resultSet.getString(phone), resultSet.getString(email));

                }else{
                    System.out.println("Cannot able to fetch guest details.");
                }

            case 3:
                query = "UPDATE guests SET name = ?, phone = ?, email = ? WHERE guest_id = ?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1,name);
                preparedStatement.setString(2,phone);
                preparedStatement.setString(3,email);
                preparedStatement.setInt(4,guest_id);
                row = preparedStatement.executeUpdate();
                if(row>0){
                    System.out.println("Data updated successfully.");
                }else{
                    System.out.println("Data not updated.");
                }

            case 4:
                query = "DELETE guests WHERE guest_id = ?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1,guest_id);
                row = preparedStatement.executeUpdate();
                if(row>0){
                    System.out.println("Guest delete successfully.");
                }else{
                    System.out.println("Guest not deleted.");
                }

            default:
                System.out.println("Enter the valid choice!");
        }
    }
}
