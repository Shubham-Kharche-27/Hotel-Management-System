package com.hotel_management_system.model;

import com.hotel_management_system.dao.Guest;

import java.sql.SQLException;
import java.util.Scanner;

public class GuestModel{

    public void guest() throws ClassNotFoundException, SQLException,InterruptedException {
        Scanner sc = new Scanner(System.in);
        Guest guest = new Guest();

        int guest_id;
        String name;
        String phone;
        String email;

        System.out.println("1. Add new guest");
        System.out.println("2. View guest details");
        System.out.println("3. Update guest Information");
        System.out.println("4. Delete guest");
        System.out.print("Enter the choice::");
        int choice = sc.nextInt();
        sc.nextLine();
        switch(choice){
            case 1:
                System.out.print("Enter guest name::");
                name = sc.nextLine();
                System.out.print("Enter guest phone::");
                phone = sc.nextLine();
                System.out.print("Enter guest email::");
                email = sc.nextLine();
                guest.GuestDaoCreate(name,phone,email);
                break;

            case 2:
                guest.GuestDaoRead();
                break;

            case 3:
                System.out.print("Enter guest Id::");
                guest_id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter guest name::");
                name = sc.nextLine();
                System.out.print("Enter guest phone::");
                phone = sc.nextLine();
                System.out.print("Enter guest email::");
                email = sc.nextLine();
                guest.GuestDaoUpdate(guest_id,name,phone,email);
                break;

            case 4:
                System.out.print("Enter guest Id::");
                guest_id = sc.nextInt();
                guest.GuestDaoDelete(guest_id);
                break;
        }
    }
}
