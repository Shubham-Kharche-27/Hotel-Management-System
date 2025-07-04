package com.hotel_management_system.model;

import com.hotel_management_system.dao.Booking;

import java.sql.SQLException;
import java.util.Scanner;

public class BookingModel {
    public void booking() throws SQLException {
        Scanner sc = new Scanner(System.in);
        Booking booking = new Booking();
        int booking_id;
        int guest_id;
        int room_id;
        String checkin_date;
        String checkout_date;

        System.out.println("1. Book room for guest");
        System.out.println("2. Checkout guest");
        System.out.println("3. View all booking");
        System.out.println("4. Back to main menu");
        System.out.print("Enter the choice::");
        int choice = sc.nextInt();

        switch(choice){
            case 1:
                System.out.print("Enter the guest id::");
                guest_id = sc.nextInt();
                System.out.print("Enter the room id::");
                room_id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter the guest checkin date::");
                checkin_date = sc.nextLine();
                System.out.print("Enter the guest checkout date::");
                checkout_date = sc.nextLine();
                booking.bookingDaoCreate(guest_id,room_id,checkin_date,checkout_date);
                booking();
                break;

            case 2:
                System.out.print("Enter the booking ID::");
                booking_id = sc.nextInt();
                booking.bookingDaoCheckout(booking_id);
                booking();
                break;

            case 3:
                booking.bookingDaoRead();
                booking();
                break;

            case 4:
                return;

            default:
                System.out.println("Enter the valid choice");
        }
    }
}
