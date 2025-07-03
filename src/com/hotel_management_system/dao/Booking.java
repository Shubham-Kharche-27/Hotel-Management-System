package com.hotel_management_system.dao;

import com.hotel_management_system.db.DbConnection;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Booking {
    DbConnection dbConnect = new DbConnection();
    Connection connection;
    {
        try{
            Connection connection = dbConnect.dbConnection();
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String query;
    public void bookingDaoCreate(int guest_id, int room_id, String checkin_date,String checkout_date) throws SQLException {
        query = "INSERT INTO bookings(guest_id,room_id,checkin_date,checkout_date) VALUES(?,?,?,?)";
        boolean isGuestIdAvailable = findGuestId(guest_id,connection,preparedStatement,query,resultSet);
        if(isGuestIdAvailable){
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,guest_id);
            preparedStatement.setInt(2,room_id);
            preparedStatement.setString(3,checkin_date);
            preparedStatement.setString(4,checkout_date);
            preparedStatement.executeUpdate();
            System.out.println("Room booked Successfully.");
        }else{
            System.out.println("Room not booked.");
        }
    }

    public void bookingDaoCheckout(int booking_id) throws SQLException {
        query = "DELETE bookings WHERE booking_id = ?";
        boolean isBookingIdAvailabe = findBookingId(booking_id,connection,preparedStatement,query,resultSet);
        if(isBookingIdAvailabe){
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,booking_id);
            preparedStatement.executeUpdate();
            System.out.println("Room checkout successfull");
        }else{
            System.out.println("Room unable to checkout try again.");
        }
    }

    public void bookingDaoRead() throws SQLException {
        query = "SELECT * FROM bookings";
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            System.out.println("+------------+----------+---------+--------------+---------------+");
            System.out.printf("| %-10s | %-8s | %-7s | %-12s | %-13s |\n",
                    "booking_id", "guest_id", "room_id", "checkin_date", "checkout_date");
            System.out.println("+------------+----------+---------+--------------+---------------+");
            System.out.printf("| %-10d | %-8d | %-7d | %-12s | %-13s |\n",
                    resultSet.getInt("booking_id"), resultSet.getInt("guest_id"), resultSet.getInt("room_id"), resultSet.getString("checkin_date"), resultSet.getString("checkout_date"));
        }
    }

    public boolean findGuestId(int guest_id,Connection connection,PreparedStatement preparedStatement,String query,ResultSet resultSet) throws SQLException{


        query = "SELECT guest_id FROM guests WHERE guest_id = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,guest_id);
        resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            return guest_id == resultSet.getInt("guest_id");
        }
        return false;
    }

    public boolean findBookingId(int booking_id, Connection connection, PreparedStatement preparedStatement, String query, ResultSet resultSet) throws SQLException{

        query = "SELECT booking_id FROM bookings WHERE booking_id = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,booking_id);
        resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            return booking_id == resultSet.getInt("booking_id");
        }
        return false;
    }

}
