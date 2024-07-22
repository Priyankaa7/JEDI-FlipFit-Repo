/*package com.flipkart.client;

import com.flipkart.bean.*;
import com.flipkart.business.CustomerService;

import java.util.List;
import java.util.Scanner;

public class GymFlipFitCustomerMenu {
    static Scanner obj = new Scanner(System.in);
    CustomerService userServiceOperation = new CustomerService();

    public boolean userLogin(String username, String pass) {
        if (validateUser(username, pass)) {
            boolean flag = true;
            System.out.println("Login Successful");
            while (flag) {
                System.out.println("\n------------------CUSTOMER MENU-----------------\n");
                System.out.println("1. View Profile");
                System.out.println("2. Book a Slot");
                System.out.println("3. View Bookings");
                System.out.println("4. Cancel Booking");
                System.out.println("5. Go Back to Previous Menu");

                int choice = Integer.parseInt(obj.nextLine());
                switch (choice) {
                    case 1:
                        viewProfile(username);
                        break;
                    case 2:
                        List<Gym> gyms = viewAllGymswithSlots();
                        printGymsAsTable(gyms);
                        System.out.println("Enter the following:");
                        System.out.println("Gym ID");
                        int gymId = Integer.parseInt(obj.nextLine());
                        System.out.println("Slot Time");
                        int time = Integer.parseInt(obj.nextLine());

                        if (bookSlot(gymId, time, username)) {
                            System.out.println("\nBooked Successfully\n");
                        } else {
                            System.out.println("\nBooking Unsuccessful\n");
                        }
                        break;
                    case 3:
                        System.out.println("My Bookings");
                        List<Bookings> bookings = viewAllBookings(username);
                        for (Bookings booking : bookings) {
                            System.out.println("Booking ID: " + booking.getBookingId() + "\nBooking Status: " + booking.getStatus() + " \nTime: " + booking.getTime() + "\nGymID: " + booking.getGymId());
                        }
                        break;
                    case 4:
                        System.out.println("My Bookings");
                        List<Bookings> allBookings = viewAllBookings(username);
                        for (Bookings booking : allBookings) {
                            System.out.println("Booking ID: " + booking.getBookingId() + "\nBooking Status: " + booking.getStatus() + " \nTime: " + booking.getTime() + "\nGymID: " + booking.getGymId());
                        }
                        System.out.println("Enter Booking ID to Cancel:");
                        int bookingId = Integer.parseInt(obj.nextLine());
                        cancelSlot(bookingId);
                        break;
                    case 5:
                        flag = false;
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            }
        } else {
            return false;
        }
        return true;
    }

    private void viewProfile(String username) {
        User user = userServiceOperation.getUserProfile(username);
        System.out.println("\n-------Profile-------");
        System.out.println("Name: " + user.getUserName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Phone: " + user.getPhoneNumber());
        System.out.println("Address: " + user.getAddress());
    }

    private void printGymsAsTable(List<Gym> gyms) {
        String leftAlignFormat = "| %-6d | %-20s | %-20s | %-20d | %-20d |%n";

        System.out.format("+--------+----------------------+----------------------+----------------------+----------------------+----------------------+\n");
        System.out.format("| Gym ID | Gym Name             | Address              | Slots                | Remaining Seats      |%n");
        System.out.format("+--------+----------------------+----------------------+----------------------+----------------------+----------------------+\n");

        for (Gym gym : gyms) {
            System.out.format(leftAlignFormat, gym.getGymId(), gym.getGymName(), gym.getGymAddress(), gym.getSlots(), 0); // Assuming slots and remaining seats are not handled here
        }

        System.out.format("+--------+----------------------+----------------------+----------------------+----------------------+----------------------+\n");
    }

    private String getSlotsString(List<Slots> slots) {
        StringBuilder slotsString = new StringBuilder();
        for (Slots slot : slots) {
            String startTime = String.format("%02d:00", slot.getTimeSlot());
            String endTime = String.format("%02d:00", slot.getTimeSlot() + 1);
            slotsString.append(startTime).append("-").append(endTime).append(", ");
        }
        return slotsString.toString();
    }

    private int getRemainingSeats(List<Slots> slots) {
        int totalSeats = 0;
        for (Slots slot : slots) {
            totalSeats += slot.getSeatCount();
        }
        return totalSeats;
    }

    public boolean validateUser(String username, String pass) {
        return userServiceOperation.validateUser(username, pass);
    }

    List<Gym> viewAllGymswithSlots() {
        System.out.println("List of Gyms");
        return userServiceOperation.getAllGymsWithSlots();
    }

    public boolean bookSlot(int gymId, int time, String email) {
        return userServiceOperation.bookSlots(gymId, time, email);
    }

    public void cancelSlot(int bookingId) {
        System.out.println("\nSlot Cancelled\n");
        userServiceOperation.cancelSlots(bookingId);
    }

    public List<Bookings> viewAllBookings(String userid) {
        return userServiceOperation.getAllBookings(userid);
    }

    public void createCustomer() {
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

        User user = new User();
        user.setEmail(ownerEmail);
        user.setAddress(address);
        user.setPassword(password);
        user.setUserName(ownerName);
        user.setPhoneNumber(phoneNo);

        userServiceOperation.createUser(user);
    }
}
*/

/*package com.flipkart.client;

import com.flipkart.bean.*;
import com.flipkart.business.CustomerService;

import java.util.List;
import java.util.Scanner;

public class GymFlipFitCustomerMenu {
    static Scanner obj = new Scanner(System.in);
    CustomerService userServiceOperation = new CustomerService();

    public boolean userLogin(String username, String pass) {
        if (validateUser(username, pass)) {
            boolean flag = true;
            System.out.println("Login Successful");
            while (flag) {
                System.out.println("\n------------------CUSTOMER MENU-----------------\n");
                System.out.println("1. View Profile");
                System.out.println("2. Book a Slot");
                System.out.println("3. View Bookings");
                System.out.println("4. Cancel Booking");
                System.out.println("5. Go Back to Previous Menu");

                int choice = Integer.parseInt(obj.nextLine());
                switch (choice) {
                    case 1:
                        viewProfile(username);
                        break;
                    case 2:
                        List<Gym> gyms = viewAllGymswithSlots();
                        printGymsAsTable(gyms);
                        System.out.println("Enter the following:");
                        System.out.println("Gym ID");
                        int gymId = Integer.parseInt(obj.nextLine());
                        System.out.println("Slot Time");
                        String timeSlot = obj.nextLine();

                        if (bookSlot(gymId, timeSlot, username)) {
                            System.out.println("\nBooked Successfully\n");
                        } else {
                            System.out.println("\nBooking Unsuccessful\n");
                        }
                        break;
                    case 3:
                        System.out.println("My Bookings");
                        List<Bookings> bookings = viewAllBookings(username);
                        for (Bookings booking : bookings) {
                            System.out.println("Booking ID: " + booking.getBookingId() + "\nBooking Status: " + booking.getStatus() + " \nTime: " + booking.getTime() + "\nGymID: " + booking.getGymId());
                        }
                        break;
                    case 4:
                        System.out.println("My Bookings");
                        List<Bookings> allBookings = viewAllBookings(username);
                        for (Bookings booking : allBookings) {
                            System.out.println("Booking ID: " + booking.getBookingId() + "\nBooking Status: " + booking.getStatus() + " \nTime: " + booking.getTime() + "\nGymID: " + booking.getGymId());
                        }
                        System.out.println("Enter Booking ID to Cancel:");
                        int bookingId = Integer.parseInt(obj.nextLine());
                        cancelSlot(bookingId);
                        break;
                    case 5:
                        flag = false;
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            }
        } else {
            return false;
        }
        return true;
    }

    private void viewProfile(String username) {
        User user = userServiceOperation.getUserProfile(username);
        System.out.println("\n-------Profile-------");
        System.out.println("Name: " + user.getUserName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Phone: " + user.getPhoneNumber());
        System.out.println("Address: " + user.getAddress());
    }

    private void printGymsAsTable(List<Gym> gyms) {
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

    private String getSlotsString(List<Slots> slots) {
        StringBuilder slotsString = new StringBuilder();
        for (Slots slot : slots) {
            slotsString.append(slot.getTimeSlot()).append(" (").append(slot.getSeatCount()).append(" seats), ");
        }
        return slotsString.toString();
    }

    private int getRemainingSeats(List<Slots> slots) {
        int totalSeats = 0;
        for (Slots slot : slots) {
            totalSeats += slot.getSeatCount();
        }
        return totalSeats;
    }

    public boolean validateUser(String username, String pass) {
        return userServiceOperation.validateUser(username, pass);
    }

    List<Gym> viewAllGymswithSlots() {
        System.out.println("List of Gyms");
        return userServiceOperation.getAllGymsWithSlots();
    }

    public boolean bookSlot(int gymId, String timeSlot, String email) {
        return userServiceOperation.bookSlots(gymId, timeSlot, email);
    }

    public void cancelSlot(int bookingId) {
        System.out.println("\nSlot Cancelled\n");
        userServiceOperation.cancelSlots(bookingId);
    }

    public List<Bookings> viewAllBookings(String userid) {
        return userServiceOperation.getAllBookings(userid);
    }

    public void createCustomer() {
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

        User user = new User();
        user.setEmail(ownerEmail);
        user.setAddress(address);
        user.setPassword(password);
        user.setUserName(ownerName);
        user.setPhoneNumber(phoneNo);

        userServiceOperation.createUser(user);
    }
}
*/

package com.flipkart.client;

import com.flipkart.bean.*;
import com.flipkart.business.CustomerService;

import java.util.List;
import java.util.Scanner;

public class GymFlipFitCustomerMenu {
    static Scanner obj = new Scanner(System.in);
    CustomerService userServiceOperation = new CustomerService();

    public boolean userLogin(String username, String pass) {
        if (validateUser(username, pass)) {
            boolean flag = true;
            System.out.println("Login Successful");
            while (flag) {
                System.out.println("\n------------------CUSTOMER MENU-----------------\n");
                System.out.println("1. View Profile");
                System.out.println("2. Book a Slot");
                System.out.println("3. View Bookings");
                System.out.println("4. Cancel Booking");
                System.out.println("5. Go Back to Previous Menu");

                int choice = Integer.parseInt(obj.nextLine());
                switch (choice) {
                    case 1:
                        viewProfile(username);
                        break;
                    case 2:
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
                        System.out.println("My Bookings");
                        List<Bookings> bookings = viewAllBookings(username);
                        for (Bookings booking : bookings) {
                            System.out.println("Booking ID: " + booking.getBookingId() + "\nBooking Status: " + booking.getStatus() + " \nTime: " + booking.getTime() + "\nGymID: " + booking.getGymId());
                        }
                        break;
                    case 4:
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
                        flag = false;
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            }
        } else {
            return false;
        }
        return true;
    }

    private void viewProfile(String username) {
        User user = userServiceOperation.getUserProfile(username);
        System.out.println("\n-------Profile-------");
        System.out.println("Name: " + user.getUserName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Phone: " + user.getPhoneNumber());
        System.out.println("Address: " + user.getAddress());
    }

    private void printGymsAsTable(List<Gym> gyms) {
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

    private String getSlotsString(List<Slots> slots) {
        StringBuilder slotsString = new StringBuilder();
        for (Slots slot : slots) {
            slotsString.append(slot.getTimeSlot()).append(" (").append(slot.getSeatCount()).append(" seats), ");
        }
        return slotsString.toString();
    }

    private int getRemainingSeats(List<Slots> slots) {
        int totalSeats = 0;
        for (Slots slot : slots) {
            totalSeats += slot.getSeatCount();
        }
        return totalSeats;
    }

    public boolean validateUser(String username, String pass) {
        return userServiceOperation.validateUser(username, pass);
    }

    List<Gym> viewAllGymswithSlots() {
        System.out.println("List of Gyms");
        return userServiceOperation.getAllGymsWithSlots();
    }

    public boolean bookSlot(int gymId, String timeSlot, String email) {
        return userServiceOperation.bookSlots(gymId, timeSlot, email);
    }

    public boolean cancelSlot(int bookingId) {
//        System.out.println("\nSlot Cancelled\n");
        return userServiceOperation.cancelSlots(bookingId);
    }

    public List<Bookings> viewAllBookings(String username) {
        return userServiceOperation.getAllBookings(username);
    }

    public void createCustomer() {
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

        User user = new User();
        user.setEmail(ownerEmail);
        user.setAddress(address);
        user.setPassword(password);
        user.setUserName(ownerName);
        user.setPhoneNumber(phoneNo);

        userServiceOperation.createUser(user);
    }
}
