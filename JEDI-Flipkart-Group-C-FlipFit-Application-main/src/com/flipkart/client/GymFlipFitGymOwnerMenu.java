package com.flipkart.client;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slots;
import com.flipkart.business.GymOwnerInterface;
import com.flipkart.business.GymOwnerService;
import com.flipkart.business.GymService;
import com.flipkart.business.GymInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class represents the menu and functionalities available to a gym owner in the GymFlipFit application.
 * It allows gym owners to manage their gyms, add new gyms, register time slots, and send their profiles for approval.
 */
public class GymFlipFitGymOwnerMenu {

    GymOwnerInterface gymOwnerService = new GymOwnerService(); // Service interface for gym owner operations
    GymInterface gymService = new GymService(); // Service interface for gym operations
    static Scanner obj = new Scanner(System.in); // Scanner object for user input

    /**
     * Method to verify gym owner's login credentials.
     * @param email The email of the gym owner
     * @param password The password of the gym owner
     * @return true if login credentials are valid, false otherwise
     */
    boolean verifyGymOwner(String email, String password) {
        return gymOwnerService.validateLogin(email, password);
    }

    /**
     * Method to handle gym owner login process.
     * @param email The email of the gym owner
     * @param password The password of the gym owner
     * @return true if login is successful, false otherwise
     */
    boolean gymOwnerLogin(String email, String password) {
        if (gymOwnerService.validateLogin(email, password)) {
            System.out.println("\nLogin Successful\n");
            String ownerId = gymOwnerService.getOwnerIdByEmail(email); // Get the ownerId using email
            boolean menuFlag = true;
            while (menuFlag) {
                // Display gym owner menu options
                System.out.println("----------------Gym Owner menu--------------------");
                System.out.println("1. Add a new gym Centre");
                System.out.println("2. View Registered Gyms ");
                System.out.println("3. Register Time Slots ");
                System.out.println("4. Send Profile for Approval");
                System.out.println("5. Quit to Main Menu");
                System.out.print("Enter your choice: ");

                int choice = Integer.parseInt(obj.nextLine());

                switch (choice) {
                    case 1:
                        addGym(ownerId); // Add a new gym
                        break;
                    case 2:
                        displayGymsByOwnerId(ownerId); // View gyms registered by the owner
                        break;
                    case 3:
                        registerTimeSlots(ownerId); // Register time slots for a gym
                        break;
                    case 4:
                        sendProfileForApproval(ownerId); // Send profile for approval
                        break;
                    case 5:
                        menuFlag = false; // Quit to main menu
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
            return true; // Return to the previous menu
        } else {
            System.out.println("Invalid login credentials.");
            return false;
        }
    }

    /**
     * Method to add a new gym for a gym owner.
     * @param ownerId The ID of the gym owner
     */
    void addGym(String ownerId) {
        Gym gym = new Gym();

        // Gather gym details from the gym owner
        System.out.println("Enter the following info:");
        System.out.println("\nEnter gym name:");
        String gymName = obj.nextLine();
        System.out.println("\nGym Address:");
        String address = obj.nextLine();

        // Set gym details
        gym.setGymAddress(address);
        gym.setGymName(gymName);
        gym.setOwnerId(ownerId);

        List<Slots> slots = new ArrayList<>();
        System.out.println("\nHow many slots to be entered?");
        int slotNo = Integer.parseInt(obj.nextLine());
        int x = 1;
        while (slotNo != 0) {
            System.out.println("Add slot no. " + x++ + "\n");
            System.out.println("\nEnter time slot (e.g., 10am - 11am):"); // Time slot format
            String timeSlot = obj.nextLine(); // Get time slot from user
            System.out.println("\nEnter available seats:");
            int number = Integer.parseInt(obj.nextLine());
            Slots slot = new Slots(x - 1, timeSlot, number); // Create new slot object
            slots.add(slot);
            slotNo--;
        }
        gym.setSlots(slots);

        gymOwnerService.addGymWithSlots(gym); // Add gym with slots using service
    }

    /**
     * Method to create a new gym owner profile in the system.
     */
    void createGymOwner() {
        // Gather gym owner details
        System.out.println("Enter the following info:");
        System.out.println("\nYour email: ");
        String ownerEmail = obj.nextLine();
        System.out.println("\nYour name: ");
        String ownerName = obj.nextLine();
        System.out.println("\nEnter a password: ");
        String password = obj.nextLine();
        System.out.println("\nPhone number: ");
        String phoneNo = obj.nextLine();
        System.out.println("\nNation ID/ Aadhaar Number: ");
        String nationalId = obj.nextLine();
        System.out.println("\nGST: ");
        String GST = obj.nextLine();
        System.out.println("\nPAN Details: ");
        String PAN = obj.nextLine();
        
        // Create gym owner object
        GymOwner gymOwner = new GymOwner();
        gymOwner.setOwnerEmail(ownerEmail);
        gymOwner.setPAN(PAN);
        gymOwner.setOwnerName(ownerName);
        gymOwner.setGST(GST);
        gymOwner.setPassword(password);
        gymOwner.setNationalId(nationalId);
        gymOwner.setPhoneNo(phoneNo);
        gymOwner.setStatus("Unverified");

        gymOwnerService.createGymOwner(gymOwner); // Create gym owner using service
    }

    /**
     * Method to display all gyms registered by a gym owner.
     * @param ownerId The ID of the gym owner
     */
    void displayGymsByOwnerId(String ownerId) {
        List<Gym> gymsList = gymService.getGymsByOwnerId(ownerId); // Retrieve gyms by owner ID
        if (gymsList.isEmpty()) {
            System.out.println("No gyms found for the owner.");
            return;
        }
        int x = 1;
        for (Gym gym : gymsList) {
            // Display gym details and slots
            System.out.println("Gym " + x + ":");
            System.out.println("Name: " + gym.getGymName());
            System.out.println("Address: " + gym.getGymAddress());
            System.out.println("Slots:");
            for (Slots slot : gym.getSlots()) {
                System.out.println("Slot ID: " + slot.getSlotsId());
                System.out.println("Time Slot: " + slot.getTimeSlot()); // Display time slot
                System.out.println("Seats: " + slot.getSeatCount());
                System.out.println();
            }
            x++;
            System.out.println();
        }
    }

    /**
     * Method to register time slots for a gym owned by the gym owner.
     * @param ownerId The ID of the gym owner
     */
    void registerTimeSlots(String ownerId) {
        // Prompt user to enter gym ID and number of slots
        System.out.println("Enter gym ID to register slots:");
        int gymId = Integer.parseInt(obj.nextLine());
        List<Slots> slots = new ArrayList<>();
        System.out.println("How many slots to be entered?");
        int slotNo = Integer.parseInt(obj.nextLine());
        int x = 1;
        while (slotNo != 0) {
            System.out.println("Add slot no. " + x++ + "\n");
            System.out.println("\nEnter time slot (e.g., 10am - 11am):");
            String timeSlot = obj.nextLine(); // Get time slot from user
            System.out.println("\nEnter available seats:");
            int number = Integer.parseInt(obj.nextLine());
            Slots slot = new Slots(x - 1, timeSlot, number); // Create new slot object
            slots.add(slot);
            slotNo--;
        }
        gymOwnerService.addSlots(gymId, slots); // Add slots using service
    }

    /**
     * Method to send gym owner's profile for approval.
     * @param ownerId The ID of the gym owner
     */
    void sendProfileForApproval(String ownerId) {
        boolean isSent = gymOwnerService.sendProfileForApproval(ownerId); // Send profile for approval using service
        if (isSent) {
            System.out.println("Profile sent for approval successfully.");
        } else {
            System.out.println("Failed to send profile for approval.");
        }
    }
}
