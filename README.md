# Hotel-Management-System
A command-line Hotel Management System in Java using JDBC. Features guest, room, and booking management with CRUD operations. Connects to MySQL for data storage. Lightweight, modular, and ideal for learning Java with database integration.

#SQL Queries

**Guest Table**
CREATE TABLE guests(
guest_id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(100),
phone VARCHAR(15),
email VARCHAR(20)
);

**Room Table**
CREATE TABLE rooms(
room_id INT PRIMARY KEY AUTO_INCREMENT,
room_number INT,
room_type VARCHAR(50),
price DECIMAL(10,2),
status VARCHAR(15)
);

**Bookings Table**
CREATE TABLE bookings(
booking_id INT PRIMARY KEY AUTO_INCREMENT,
guest_id INT,
room_id INT,
checkin_date VARCHAR(20),
checkout_date VARCHAR(20),
FOREIGN KEY (guest_id)
REFERENCES guests(guest_id),
FOREIGN KEY (room_id)
REFERENCES rooms(room_id)
);
