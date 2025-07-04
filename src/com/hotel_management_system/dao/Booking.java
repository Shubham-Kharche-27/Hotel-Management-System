package com.hotel_management_system.dao;

import com.hotel_management_system.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Booking {
    DbConnection dbConnect = new DbConnection();
    Connection connection;

    public Booking() {
        connection = dbConnect.dbConnection();
        if (connection == null) {
            throw new RuntimeException("Failed to establish database connection");
        }
    }
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String query;
    public void bookingDaoCreate(int guest_id, int room_id, String checkin_date, String checkout_date) throws SQLException {
        String query = "INSERT INTO bookings(guest_id,room_id,checkin_date,checkout_date) VALUES(?,?,?,?)";

        if (findGuestId(guest_id, connection)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, guest_id);
                preparedStatement.setInt(2, room_id);
                preparedStatement.setString(3, checkin_date);
                preparedStatement.setString(4, checkout_date);
                preparedStatement.executeUpdate();
                System.out.println("Room booked Successfully.");
            }
        } else {
            System.out.println("Room not booked.");
        }
        preparedStatement.close();
        connection.close();
    }


    public void bookingDaoCheckout(int booking_id) throws SQLException {
        String query = "DELETE FROM bookings WHERE booking_id = ?";
        if (findBookingId(booking_id, connection)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, booking_id);
                int rowsAffected = preparedStatement.executeUpdate(); // This is correct
                if (rowsAffected > 0) {
                    System.out.println("Room checkout successful.");
                } else {
                    System.out.println("Booking ID not found.");
                }
            }
        } else {
            System.out.println("Room unable to checkout. Try again.");
        }
        preparedStatement.close();
        connection.close();
    }


    public void bookingDaoRead() throws SQLException {
        query = "SELECT * FROM bookings";
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
        System.out.println("+------------+----------+---------+--------------+---------------+");
        System.out.printf("| %-10s | %-8s | %-7s | %-12s | %-13s |\n",
                "booking_id", "guest_id", "room_id", "checkin_date", "checkout_date");
        System.out.println("+------------+----------+---------+--------------+---------------+");
        while(resultSet.next()){
            System.out.printf("| %-10d | %-8d | %-7d | %-12s | %-13s |\n",
                    resultSet.getInt("booking_id"), resultSet.getInt("guest_id"), resultSet.getInt("room_id"), resultSet.getString("checkin_date"), resultSet.getString("checkout_date"));
            System.out.println("+------------+----------+---------+--------------+---------------+");
        }
        preparedStatement.close();
        connection.close();
    }

    public boolean findGuestId(int guest_id, Connection connection) throws SQLException {
        String query = "SELECT guest_id FROM guests WHERE guest_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, guest_id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next() && guest_id == resultSet.getInt("guest_id");
            }
        }
    }


    public boolean findBookingId(int booking_id, Connection connection) throws SQLException {
        String query = "SELECT booking_id FROM bookings WHERE booking_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, booking_id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next(); // No need to compare values manually
            }
        }
    }

}
