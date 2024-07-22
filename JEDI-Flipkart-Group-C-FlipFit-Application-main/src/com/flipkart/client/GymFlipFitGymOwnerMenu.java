/*package com.flipkart.client;

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

public class GymFlipFitGymOwnerMenu {

    GymOwnerInterface gymOwnerService = new GymOwnerService();
    GymInterface gymService = new GymService();
    static Scanner obj = new Scanner(System.in);

    boolean verifyGymOwner(String email, String password) {
        return gymOwnerService.validateLogin(email, password);
    }

    boolean gymOwnerLogin(String email, String password) {
        if (gymOwnerService.validateLogin(email, password)) {
            System.out.println("\nLogin Successful\n");
            String ownerId = gymOwnerService.getOwnerIdByEmail(email); // Get the ownerId using email
            while (true) {
                System.out.println("----------------Gym Owner menu--------------------");
                System.out.println("1. Add a new gym Centre");
                System.out.println("2. View Registered Gyms ");
                System.out.println("3. Register Time Slots ");
                System.out.println("4. Send Profile for Approval");
                System.out.println("5. Quit");
                System.out.print("Enter your choice: ");

                int choice = Integer.parseInt(obj.nextLine());

                switch (choice) {
                    case 1:
                        addGym(ownerId);
                        break;
                    case 2:
                        displayGymsByOwnerId(ownerId);
                        break;
                    case 3:
                        registerTimeSlots(ownerId);
                        break;
                    case 4:
                        sendProfileForApproval(ownerId);
                        break;
                    case 5:
                        System.exit(0);
                        return true;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid login credentials.");
            return false;
        }
    }

    void addGym(String ownerId) {
        Gym gym = new Gym();

        System.out.println("Enter the following info:");
        System.out.println("\nEnter gym name:");
        String gymName = obj.nextLine();
        System.out.println("\nGym Address:");
        String address = obj.nextLine();

        gym.setGymAddress(address);
        gym.setGymName(gymName);
        gym.setOwnerId(ownerId);

        List<Slots> slots = new ArrayList<>();
        System.out.println("\nHow many slots to be entered?");
        int slotNo = Integer.parseInt(obj.nextLine());
        int x = 1;
        while (slotNo != 0) {
            System.out.println("Add slot no. " + x++ + "\n");
            System.out.println("\nEnter start time:");
            int startTime = Integer.parseInt(obj.nextLine());
            System.out.println("\nEnter available seats:");
            int number = Integer.parseInt(obj.nextLine());
            Slots slot = new Slots(x - 1, startTime, number);
            slots.add(slot);
            slotNo--;
        }
        gym.setSlots(slots);

        gymOwnerService.addGymWithSlots(gym);
    }

    void createGymOwner() {
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
        GymOwner gymOwner = new GymOwner();
        gymOwner.setOwnerEmail(ownerEmail);
        gymOwner.setPAN(PAN);
        gymOwner.setOwnerName(ownerName);
        gymOwner.setGST(GST);
        gymOwner.setPassword(password);
        gymOwner.setNationalId(nationalId);
        gymOwner.setPhoneNo(phoneNo);
        gymOwner.setStatus("Unverified");

        gymOwnerService.createGymOwner(gymOwner);
    }

    void displayGymsByOwnerId(String ownerId) {
        List<Gym> gymsList = gymService.getGymsByOwnerId(ownerId);
        int x = 1;
        for (Gym gym : gymsList) {
            System.out.println("Gym " + x + ":");
            System.out.println("Name: " + gym.getGymName());
            System.out.println("Address: " + gym.getGymAddress());
            System.out.println("Slots:");
            for (Slots slot : gym.getSlots()) {
                System.out.println("Slot ID: " + slot.getSlotsId());
                System.out.println("Slot Time: " + slot.getStartTime() + " - " + (slot.getStartTime() + 1));
                System.out.println("Seats: " + slot.getSeatCount());
                System.out.println();
            }
            x++;
            System.out.println();
        }
    }

    void registerTimeSlots(String ownerId) {
        System.out.println("Enter gym ID to register slots:");
        int gymId = Integer.parseInt(obj.nextLine());
        List<Slots> slots = new ArrayList<>();
        System.out.println("How many slots to be entered?");
        int slotNo = Integer.parseInt(obj.nextLine());
        int x = 1;
        while (slotNo != 0) {
            System.out.println("Add slot no. " + x++ + "\n");
            System.out.println("\nEnter start time:");
            int startTime = Integer.parseInt(obj.nextLine());
            System.out.println("\nEnter available seats:");
            int number = Integer.parseInt(obj.nextLine());
            Slots slot = new Slots(x - 1, startTime, number);
            slots.add(slot);
            slotNo--;
        }
        gymOwnerService.addSlots(gymId, slots);
    }

    void sendProfileForApproval(String ownerId) {
        boolean isSent = gymOwnerService.sendProfileForApproval(ownerId);
        if (isSent) {
            System.out.println("Profile sent for approval successfully.");
        } else {
            System.out.println("Failed to send profile for approval.");
        }
    }
}*/

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

public class GymFlipFitGymOwnerMenu {

    GymOwnerInterface gymOwnerService = new GymOwnerService();
    GymInterface gymService = new GymService();
    static Scanner obj = new Scanner(System.in);

    boolean verifyGymOwner(String email, String password) {
        return gymOwnerService.validateLogin(email, password);
    }

    boolean gymOwnerLogin(String email, String password) {
        if (gymOwnerService.validateLogin(email, password)) {
            System.out.println("\nLogin Successful\n");
            String ownerId = gymOwnerService.getOwnerIdByEmail(email); // Get the ownerId using email
            boolean menuFlag = true;
            while (menuFlag) {
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
                        addGym(ownerId);
                        break;
                    case 2:
                        displayGymsByOwnerId(ownerId);
                        break;
                    case 3:
                        registerTimeSlots(ownerId);
                        break;
                    case 4:
                        sendProfileForApproval(ownerId);
                        break;
                    case 5:
                        menuFlag = false; // Set flag to false to exit inner loop
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

    void addGym(String ownerId) {
        Gym gym = new Gym();

        System.out.println("Enter the following info:");
        System.out.println("\nEnter gym name:");
        String gymName = obj.nextLine();
        System.out.println("\nGym Address:");
        String address = obj.nextLine();

        gym.setGymAddress(address);
        gym.setGymName(gymName);
        gym.setOwnerId(ownerId);

        List<Slots> slots = new ArrayList<>();
        System.out.println("\nHow many slots to be entered?");
        int slotNo = Integer.parseInt(obj.nextLine());
        int x = 1;
        while (slotNo != 0) {
            System.out.println("Add slot no. " + x++ + "\n");
            System.out.println("\nEnter time slot (e.g., 10am - 11am):");  // Changed to String
            String timeSlot = obj.nextLine();  // Changed to String
            System.out.println("\nEnter available seats:");
            int number = Integer.parseInt(obj.nextLine());
            Slots slot = new Slots(x - 1, timeSlot, number);  // Changed to String
            slots.add(slot);
            slotNo--;
        }
        gym.setSlots(slots);

        gymOwnerService.addGymWithSlots(gym);
    }

    void createGymOwner() {
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
        GymOwner gymOwner = new GymOwner();
        gymOwner.setOwnerEmail(ownerEmail);
        gymOwner.setPAN(PAN);
        gymOwner.setOwnerName(ownerName);
        gymOwner.setGST(GST);
        gymOwner.setPassword(password);
        gymOwner.setNationalId(nationalId);
        gymOwner.setPhoneNo(phoneNo);
        gymOwner.setStatus("Unverified");

        gymOwnerService.createGymOwner(gymOwner);
    }

    void displayGymsByOwnerId(String ownerId) {
        List<Gym> gymsList = gymService.getGymsByOwnerId(ownerId);
        if (gymsList.isEmpty()) {
            System.out.println("No gyms found for the owner.");
            return;
        }
        int x = 1;
        for (Gym gym : gymsList) {
            System.out.println("Gym " + x + ":");
            System.out.println("Name: " + gym.getGymName());
            System.out.println("Address: " + gym.getGymAddress());
            System.out.println("Slots:");
            for (Slots slot : gym.getSlots()) {
                System.out.println("Slot ID: " + slot.getSlotsId());
                System.out.println("Time Slot: " + slot.getTimeSlot());  // Updated
                System.out.println("Seats: " + slot.getSeatCount());
                System.out.println();
            }
            x++;
            System.out.println();
        }
    }

    void registerTimeSlots(String ownerId) {
        System.out.println("Enter gym ID to register slots:");
        int gymId = Integer.parseInt(obj.nextLine());
        List<Slots> slots = new ArrayList<>();
        System.out.println("How many slots to be entered?");
        int slotNo = Integer.parseInt(obj.nextLine());
        int x = 1;
        while (slotNo != 0) {
            System.out.println("Add slot no. " + x++ + "\n");
            System.out.println("\nEnter time slot (e.g., 10am - 11am):");
            String timeSlot = obj.nextLine();  // Changed to String
            System.out.println("\nEnter available seats:");
            int number = Integer.parseInt(obj.nextLine());
            Slots slot = new Slots(x - 1, timeSlot, number);  // Changed to String
            slots.add(slot);
            slotNo--;
        }
        gymOwnerService.addSlots(gymId, slots);
    }

    void sendProfileForApproval(String ownerId) {
        boolean isSent = gymOwnerService.sendProfileForApproval(ownerId);
        if (isSent) {
            System.out.println("Profile sent for approval successfully.");
        } else {
            System.out.println("Failed to send profile for approval.");
        }
    }
}
