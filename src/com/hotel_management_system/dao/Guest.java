package com.hotel_management_system.dao;

import com.hotel_management_system.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Guest {

        DbConnection dbConnect = new DbConnection();
        Connection connection;

        public Guest() {
            connection = dbConnect.dbConnection();
            if (connection == null) {
                throw new RuntimeException("Failed to establish database connection");
            }
        }
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String query;
        int row = 0;

    public void GuestDaoCreate(String name,String phone,String email) throws SQLException,InterruptedException {
                query = "INSERT INTO guests(name,phone,email) VALUES(?,?,?)";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1,name);
                preparedStatement.setString(2,phone);
                preparedStatement.setString(3,email);
                row = preparedStatement.executeUpdate();
                Thread.sleep(2000);
                if(row>0){
                    System.out.println("Guest was Added Successfully.");
                }
                else{
                    System.out.println("Guest cannot added.");
                }
    }

    public void GuestDaoRead() throws SQLException{
        query = "SELECT * FROM guests";
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
        System.out.println("+----------+--------------+----------------------+----------------+");
        System.out.printf("| %-8s | %-12s | %-20s | %-14s |\n", "guest_id", "name", "phone", "email");
        while(resultSet.next()){
            System.out.println("+----------+--------------+----------------------+----------------+");
            System.out.printf("| %-8s | %-12s | %-20s | %-14s |\n", resultSet.getInt("guest_id"), resultSet.getString("name"), resultSet.getString("phone"), resultSet.getString("email"));
        }
    }

    public void GuestDaoUpdate(int guest_id,String name,String phone,String email)throws SQLException{

        if(findGuestId(guest_id)){
            query = "UPDATE guests SET name = ?, phone = ?, email = ? WHERE guest_id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,phone);
            preparedStatement.setString(3,email);
            preparedStatement.setInt(4,guest_id);
            preparedStatement.executeUpdate();
            System.out.println("Data updated successfully.");
        }else{
            System.out.println("Data not updated, cannot able to fetch guest.");
        }
    }

    public void GuestDaoDelete(int guest_id)throws SQLException{
            if(findGuestId(guest_id)){
                query = "DELETE FROM guests WHERE guest_id = ?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1,guest_id);
                row = preparedStatement.executeUpdate();
                System.out.println("Guest delete successfully.");
            }else{
                System.out.println("Guest not deleted.");
            }
    }

    public boolean findGuestId(int guest_id) throws SQLException{


        query = "SELECT guest_id FROM guests WHERE guest_id = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,guest_id);
        resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            return guest_id == resultSet.getInt("guest_id");
        }
        return false;
    }
}
