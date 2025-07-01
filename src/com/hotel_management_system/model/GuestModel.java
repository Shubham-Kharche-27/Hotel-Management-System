package com.hotel_management_system.model;

import com.hotel_management_system.dao.Guest;

import java.sql.SQLException;
import java.util.Scanner;

public class GuestModel{
    public void Guest(Scanner sc) throws ClassNotFoundException, SQLException,InterruptedException {

        Guest guest = new Guest();

        System.out.println("1. Add new guest");
        System.out.println("2. View guest details");
        System.out.println("3. Update guest Information");
        System.out.println("4. Delete guest");
        System.out.print("Enter the choice::");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                System.out.print("Enter guest Id::");
                int guest_id = sc.nextInt();
                System.out.print("Enter guest name::");
                String name = sc.nextLine();
                sc.next();
                System.out.print("Enter guest phone::");
                String phone = sc.nextLine();
                System.out.print("Enter guest email::");
                String email = sc.nextLine();
                guest.GuestDao(guest_id,name,phone,email,choice);

            case 2:

        }
    }
}
