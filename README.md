# 🏨 Hotel Management System (Java + JDBC + MySQL)

A **Command-Line Hotel Management System** built using **Java**, connected to a **MySQL database** via **JDBC**. This project provides basic **CRUD functionality** for managing guests, rooms, and bookings — ideal for learning how to integrate Java applications with relational databases.

---

## 📌 Features

### 👤 Guest Management
- Add new guests with name, phone number, and email
- View guest records
- Update guest information
- Delete guest entries

### 🏠 Room Management
- Add new rooms with number, type, price, and status
- View all rooms
- Update room details
- Delete rooms

### 📅 Booking Management
- Create bookings linking guests with rooms
- Set check-in and check-out dates
- View all bookings

---

## 🛠️ Technologies Used

- **Java** (JDK 8+)
- **JDBC** (Java Database Connectivity)
- **MySQL** (8.0+ recommended)
- **Command Line Interface** (CLI-based interaction)

---

**How to Setup**
1. Download and Install MySQL server and workbench
2. Download and Install Intellij Idea
3. Download and Open the project or fork into your repository and clone it into your local repository
4. Download mysql connector j jar and import in the project as a external libraries
5. Create database and tables as given in readme
6. Connect the database with code just change url,username and password in DbConnection file
7. You are good to go...

---

**SQL Queries**

Database Name : hotel_management_system

***Guest Table***

Table Name : guests

| Field     | Type         | Null | Key | Default | Extra           |
| --------- | ------------ | ---- | --- | ------- | --------------- |
| guest\_id | int          | NO   | PRI | NULL    | auto\_increment |
| name      | varchar(100) | YES  |     | NULL    |                 |
| phone     | varchar(15)  | YES  |     | NULL    |                 |
| email     | varchar(20)  | YES  |     | NULL    |                 |



***Room Table***

Table Name : guests

| Field        | Type          | Null | Key | Default | Extra           |
| ------------ | ------------- | ---- | --- | ------- | --------------- |
| room\_id     | int           | NO   | PRI | NULL    | auto\_increment |
| room\_number | int           | YES  |     | NULL    |                 |
| room\_type   | varchar(50)   | YES  |     | NULL    |                 |
| price        | decimal(10,2) | YES  |     | NULL    |                 |
| status       | varchar(15)   | YES  |     | NULL    |                 |



***Bookings Table***

Table Name : bookings

| Field          | Type | Null | Key | Default | Extra           |
| -------------- | ---- | ---- | --- | ------- | --------------- |
| booking\_id    | int  | NO   | PRI | NULL    | auto\_increment |
| guest\_id      | int  | YES  | MUL | NULL    |                 |
| room\_id       | int  | YES  | MUL | NULL    |                 |
| checkin\_date  | date | YES  |     | NULL    |                 |
| checkout\_date | date | YES  |     | NULL    |                 |



#Note : Its not optimal now missing some egde cases soon resolve it...
