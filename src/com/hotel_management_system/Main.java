package com.hotel_management_system;

import com.hotel_management_system.model.BookingModel;
import com.hotel_management_system.model.GuestModel;
import com.hotel_management_system.model.RoomModel;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GuestModel guestModel = new GuestModel();
        RoomModel roomModel = new RoomModel();
        BookingModel bookingModel = new BookingModel();
        while(true){
            System.out.println("----------Menu----------");
            System.out.println("1. Guest Management");
            System.out.println("2. Room Management");
            System.out.println("3. Booking Management");
            System.out.println("4. Exit");
            System.out.print("Enter the choice::");
            int choice = sc.nextInt();

            try{
                switch(choice){
                    case 1:
                        guestModel.guest();
                        break;

                    case 2:
                        roomModel.room();
                        break;

                    case 3:
                        bookingModel.booking();
                        break;

                    case 4:
                        System.out.print("Hotel management system closing");
                        int i=0;
                        while(i<4){
                            try{
                                System.out.print(".");
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                System.out.println(e.getMessage());
                            }
                            i++;
                        }
                        return;

                    default:
                        System.out.println("Enter the valid choice!");
                }
            }catch (ClassNotFoundException | InterruptedException | SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
