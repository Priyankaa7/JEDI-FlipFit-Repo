package com.flipkart.client;

import com.flipkart.bean.*;
import com.flipkart.business.CustomerService;

import java.util.List;
import java.util.Scanner;

/**
 * This class represents the menu and functionalities available to a customer in the GymFlipFit application.
 * It allows customers to login, view profile, book slots in gyms, view and cancel their bookings.
 */
public class GymFlipFitCustomerMenu {
    static Scanner obj = new Scanner(System.in); // Scanner object for user input
    CustomerService userServiceOperation = new CustomerService(); // Service class for business operations

    /**
     * Method to handle customer login.
     * @param username The username (email) of the customer
     * @param pass The password of the customer
     * @return true if login is successful, false otherwise
     */
    public boolean userLogin(String username, String pass) {
        // Validate user credentials
        if (validateUser(username, pass)) {
            boolean flag = true;
            System.out.println("Login Successful");
            while (flag) {
                // Display customer menu options
                System.out.println("\n------------------CUSTOMER MENU-----------------\n");
                System.out.println("1. View Profile");
                System.out.println("2. Book a Slot");
                System.out.println("3. View Bookings");
                System.out.println("4. Cancel Booking");
                System.out.println("5. Go Back to Previous Menu");

                int choice = Integer.parseInt(obj.nextLine());
                switch (choice) {
                    case 1:
                        viewProfile(username); // View customer profile
                        break;
                    case 2:
                        // View available gyms and book a slot
                        List<Gym> gyms = viewAllGymswithSlots();
                        printGymsAsTable(gyms);
                        System.out.println("Enter the following:");
                        System.out.println("Gym ID");
                        int gymId = Integer.parseInt(obj.nextLine());
                        System.out.println("Slot Time (in HH:mm:ss format, e.g., 13:00:00 for 1 PM)");
                        String timeSlot = obj.nextLine();

                        if (bookSlot(gymId, timeSlot, username)) {
                            System.out.println("\nBooked Successfully\n");
                        } else {
                            System.out.println("\nBooking Unsuccessful\n");
                        }
                        break;
                    case 3:
                        // View customer's bookings
                        System.out.println("My Bookings");
                        List<Bookings> bookings = viewAllBookings(username);
                        for (Bookings booking : bookings) {
                            System.out.println("Booking ID: " + booking.getBookingId() + "\nBooking Status: " + booking.getStatus() + " \nTime: " + booking.getTime() + "\nGymID: " + booking.getGymId());
                        }
                        break;
                    case 4:
                        // View and cancel customer's bookings
                        System.out.println("My Bookings");
                        List<Bookings> allBookings = viewAllBookings(username);
                        for (Bookings booking : allBookings) {
                            System.out.println("Booking ID: " + booking.getBookingId() + "\nBooking Status: " + booking.getStatus() + " \nTime: " + booking.getTime() + "\nGymID: " + booking.getGymId());
                        }
                        System.out.println("Enter Booking ID to Cancel:");
                        int bookingId = Integer.parseInt(obj.nextLine());
                        if (cancelSlot(bookingId)) {
                            System.out.println("\nSlot Cancelled\n");
                        } else {
                            System.out.println("\nCancellation Unsuccessful\n");
                        }
                        break;
                    case 5:
                        flag = false; // Exit the customer menu
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            }
        } else {
            return false; // Return false if login credentials are invalid
        }
        return true; // Return true after successful login and operations
    }

    /**
     * Method to view customer's profile.
     * @param username The username (email) of the customer
     */
    private void viewProfile(String username) {
        // Retrieve and display customer profile information
        User user = userServiceOperation.getUserProfile(username);
        System.out.println("\n-------Profile-------");
        System.out.println("Name: " + user.getUserName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Phone: " + user.getPhoneNumber());
        System.out.println("Address: " + user.getAddress());
    }

    /**
     * Method to display available gyms with their slots as a table.
     * @param gyms List of gyms to display
     */
    private void printGymsAsTable(List<Gym> gyms) {
        // Format and print gyms and their available slots
        String leftAlignFormat = "| %-6d | %-20s | %-20s | %-50s | %-20d |%n";

        System.out.format("+--------+----------------------+----------------------+----------------------------------------------------+----------------------+\n");
        System.out.format("| Gym ID | Gym Name             | Address              | Slots                                              | Remaining Seats      |%n");
        System.out.format("+--------+----------------------+----------------------+----------------------------------------------------+----------------------+\n");

        for (Gym gym : gyms) {
            String slotsInfo = getSlotsString(gym.getSlots());
            int remainingSeats = getRemainingSeats(gym.getSlots());
            System.out.format(leftAlignFormat, gym.getGymId(), gym.getGymName(), gym.getGymAddress(), slotsInfo, remainingSeats);
        }

        System.out.format("+--------+----------------------+----------------------+----------------------------------------------------+----------------------+\n");
    }

    /**
     * Method to get slots information as a string.
     * @param slots List of slots for a gym
     * @return String representation of slots information
     */
    private String getSlotsString(List<Slots> slots) {
        // Generate string representation of slots with their timings and available seats
        StringBuilder slotsString = new StringBuilder();
        for (Slots slot : slots) {
            slotsString.append(slot.getTimeSlot()).append(" (").append(slot.getSeatCount()).append(" seats), ");
        }
        return slotsString.toString();
    }

    /**
     * Method to calculate total remaining seats in all slots of a gym.
     * @param slots List of slots for a gym
     * @return Total number of remaining seats
     */
    private int getRemainingSeats(List<Slots> slots) {
        // Calculate and return total remaining seats in all slots of a gym
        int totalSeats = 0;
        for (Slots slot : slots) {
            totalSeats += slot.getSeatCount();
        }
        return totalSeats;
    }

    /**
     * Method to validate customer's login credentials.
     * @param username The username (email) of the customer
     * @param pass The password of the customer
     * @return true if credentials are valid, false otherwise
     */
    public boolean validateUser(String username, String pass) {
        // Validate customer login credentials using business service
        return userServiceOperation.validateUser(username, pass);
    }

    /**
     * Method to retrieve list of all gyms along with their available slots.
     * @return List of gyms with slots information
     */
    List<Gym> viewAllGymswithSlots() {
        // Retrieve and return list of all gyms with available slots using business service
        System.out.println("List of Gyms");
        return userServiceOperation.getAllGymsWithSlots();
    }

    /**
     * Method to book a slot in a gym for a customer.
     * @param gymId The ID of the gym where slot is to be booked
     * @param timeSlot The time slot to be booked (in HH:mm:ss format)
     * @param email The email (username) of the customer booking the slot
     * @return true if booking is successful, false otherwise
     */
    public boolean bookSlot(int gymId, String timeSlot, String email) {
        // Book a slot in a gym for a customer using business service
        return userServiceOperation.bookSlots(gymId, timeSlot, email);
    }

    /**
     * Method to cancel a booked slot for a customer.
     * @param bookingId The ID of the booking to be cancelled
     * @return true if cancellation is successful, false otherwise
     */
    public boolean cancelSlot(int bookingId) {
        // Cancel a booked slot for a customer using business service
        return userServiceOperation.cancelSlots(bookingId);
    }

    /**
     * Method to retrieve all bookings of a customer.
     * @param username The username (email) of the customer
     * @return List of bookings made by the customer
     */
    public List<Bookings> viewAllBookings(String username) {
        // Retrieve and return all bookings of a customer using business service
        return userServiceOperation.getAllBookings(username);
    }

    /**
     * Method to create a new customer profile in the system.
     */
    public void createCustomer() {
        // Gather customer information and create a new customer profile using business service
        System.out.println("Enter the following info:");
        System.out.println("\nYour email: ");
        String ownerEmail = obj.nextLine();
        System.out.println("\nYour name: ");
        String ownerName = obj.nextLine();
        System.out.println("\nEnter a password: ");
        String password = obj.nextLine();
        System.out.println("\nPhone number: ");
        String phoneNo = obj.nextLine();
        System.out.println("\nEnter Address ");
        String address = obj.nextLine();

        // Create user object with provided information
        User user = new User();
        user.setEmail(ownerEmail);
        user.setAddress(address);
        user.setPassword(password);
        user.setUserName(ownerName);
        user.setPhoneNumber(phoneNo);

        // Call business service to create the customer profile
        userServiceOperation.createUser(user);
    }
}
