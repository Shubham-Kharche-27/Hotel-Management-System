package com.hotel_management_system.model;

import com.hotel_management_system.dao.Room;

import java.sql.SQLException;
import java.util.Scanner;

public class RoomModel {
    public void room() throws SQLException{
        Scanner sc = new Scanner(System.in);
        Room room = new Room();

        int room_id;
        int room_number;
        String room_type;
        double price;
        String status;
        System.out.println("1. Add new room");
        System.out.println("2. View all rooms");
        System.out.println("3. Update room details");
        System.out.println("4. Delete room");
        System.out.print("Enter the choice::");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                System.out.print("Enter the room_number::");
                room_number = sc.nextInt();
                System.out.print("Enter the room_type::");
                room_type = sc.nextLine();
                sc.next();
                System.out.print("Enter the price::");
                price = sc.nextDouble();
                System.out.print("Enter the status::");
                status = sc.nextLine();
                sc.next();
                room.roomDaoCreate(room_number,room_type,price,status);

            case 2:
                room.roomDaoRead();

            case 3:
                System.out.print("Enter the room id::");
                room_id = sc.nextInt();
                System.out.print("Enter the room number::");
                room_number = sc.nextInt();
                System.out.print("Enter the room type::");
                room_type = sc.nextLine();
                sc.next();
                System.out.print("Enter the price::");
                price = sc.nextDouble();
                System.out.print("Enter the status::");
                status = sc.nextLine();
                sc.next();
                room.roomDaoUpdate(room_id,room_number,room_type,price,status);

            case 4:
                System.out.print("Enter the Room id::");
                room_id = sc.nextInt();
                room.roomDaoDelete(room_id);
        }
        sc.close();
    }
}
