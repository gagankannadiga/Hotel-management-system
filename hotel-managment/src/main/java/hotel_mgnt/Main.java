package hotel_mgnt;

import hotel_mgnt_DAO.*;
import hotel_mgnt_entity.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final UserDAO userDAO = new UserDAO();
    private static final RoomDAO roomDAO = new RoomDAO();
    private static final BookingDAO bookingDAO = new BookingDAO();
    private static final PaymentDAO paymentDAO = new PaymentDAO();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Hotel Management System ---");
            System.out.println("1. Add User");
            System.out.println("2. View Users");
            System.out.println("3. Add Room");
            System.out.println("4. View Rooms");
            System.out.println("5. Make Booking");
            System.out.println("6. Make Payment");
            System.out.println("7. View Bookings");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: addUser(); break;
                case 2: viewUsers(); break;
                case 3: addRoom(); break;
                case 4: viewRooms(); break;
                case 5: makeBooking(); break;
                case 6: makePayment(); break;
                case 7: viewBookings(); break;
                case 8: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addUser() {
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        System.out.print("Enter Role (admin/user): ");
        String role = scanner.nextLine();

        User user = new User(username, email, password, role);
        userDAO.saveUser(user);
        System.out.println("✅ User added successfully!");
    }

    private static void viewUsers() {
        List<User> users = userDAO.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("⚠ No users found!");
        } else {
            users.forEach(System.out::println);
        }
    }

    private static void addRoom() {
        System.out.print("Enter Room Number: ");
        int roomNumber = scanner.nextInt();

        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Room Type: ");
        String type = scanner.nextLine();

        boolean isAvailable = getBooleanInput("Is Available? (true/false or 1/0): ");

        Room room = new Room();
        roomDAO.saveRoom(room);
        System.out.println("✅ Room added successfully!");
    }

    private static boolean getBooleanInput(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.next().toLowerCase();
            if (input.equals("true") || input.equals("1")) {
                return true;
            } else if (input.equals("false") || input.equals("0")) {
                return false;
            } else {
                System.out.println("⚠ Invalid input! Enter true/false or 1/0.");
            }
        }
    }

    private static void viewRooms() {
        List<Room> rooms = roomDAO.getAllRooms();
        if (rooms.isEmpty()) {
            System.out.println("⚠ No rooms available!");
        } else {
            rooms.forEach(System.out::println);
        }
    }

    private static void makeBooking() {
        viewUsers();
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        User user = userDAO.getUserById(userId);
        if (user == null) {
            System.out.println("⚠ User not found!");
            return;
        }

        viewRooms();
        System.out.print("Enter Room ID: ");
        int roomId = scanner.nextInt();
        Room room = roomDAO.getRoomById(roomId);
        
        if (room == null) {
            System.out.println("⚠ Room not found!");
            return;
        }

        // Check if the room is available before booking
        if (!room.isAvailable()) {
            System.out.println("⚠ Room is already booked!");
            return;
        }

        scanner.nextLine(); // Consume newline
        System.out.print("Enter Booking Date (YYYY-MM-DD): ");
        String bookingDate = scanner.nextLine();

        Booking booking = new Booking(bookingDate, "Confirmed", room, user);
        bookingDAO.saveBooking(booking);

        // Mark room as unavailable
        room.setAvailable(false);
        roomDAO.updateRoom(room);

        System.out.println("✅ Booking successfully added!");
    }

    private static void makePayment() {
        System.out.print("Enter Booking ID: ");
        int bookingId = scanner.nextInt();
        Booking booking = bookingDAO.getBookingById(bookingId);
        if (booking == null) {
            System.out.println("⚠ Booking not found!");
            return;
        }

        System.out.print("Enter Payment Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Payment Date (YYYY-MM-DD): ");
        String paymentDate = scanner.nextLine();
        System.out.print("Enter Payment Method: ");
        String paymentMethod = scanner.nextLine();

        Payment payment = new Payment(amount, paymentDate, paymentMethod, booking);
        paymentDAO.savePayment(payment);
        System.out.println("✅ Payment successful!");
    }

    private static void viewBookings() {
        List<Booking> bookings = bookingDAO.getAllBookings();
        if (bookings.isEmpty()) {
            System.out.println("⚠ No bookings found!");
        } else {
            bookings.forEach(System.out::println);
        }
    }
}