# Hotel Management System

---

## Project Summary
The Hotel Management System is a Java-based application designed to manage core hotel operations, including user registration, room management, booking reservations, and payments. The system uses **Hibernate ORM** for efficient database interactions and **MariaDB/MySQL** for data storage.

## Objective
The main goal of this project is to streamline hotel operations by providing a user-friendly, menu-driven system for managing:
* Users (Admins & Customers)
* Rooms (Availability, Pricing, and Types)
* Bookings (Reservations and Status Updates)
* Payments (Transaction Tracking)

## Technologies Used
* **Java (JDK 8+)**: The core development language.
* **Hibernate ORM**: Used for database interaction.
* **MariaDB/MySQL**: The relational database for data storage.
* **JPA (Java Persistence API)**: Manages entity persistence.
* **Maven**: The project build and dependency management tool.

## Project Modules
### 1. User Management
* Add new users with Admin and Customer roles.
* View a list of all registered users.

### 2. Room Management
* Add new rooms with details like room number, price, and type.
* Check the availability of rooms.

### 3. Booking System
* Book available rooms for registered users.
* View and check booking details.

### 4. Payment System
* Record payments for completed bookings.
* Store payment method and amount.

## How It Works
1.  An Admin or User logs into the system.
2.  An Admin can add new rooms and specify their price and type.
3.  Users can then book any of the available rooms.
4.  Payment is recorded after a booking is made.
5.  All system changes are automatically updated in the database using Hibernate.
