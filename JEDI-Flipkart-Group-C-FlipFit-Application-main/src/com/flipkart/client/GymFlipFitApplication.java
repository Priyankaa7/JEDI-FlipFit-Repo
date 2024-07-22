package com.flipkart.client;

import com.flipkart.business.GymOwnerService;
import com.flipkart.business.CustomerService;
import com.flipkart.business.CustomerInterface;

import java.util.Scanner;

/**
 * The GymFlipFitApplication class implements a console-based application for managing FlipFit system operations.
 */
public class GymFlipFitApplication {
    // Instances of menus and services
    static GymFlipFitGymOwnerMenu owner = new GymFlipFitGymOwnerMenu();
    static GymFlipFitCustomerMenu customer = new GymFlipFitCustomerMenu();
    static GymOwnerService gymOwnerService = new GymOwnerService();
    static CustomerInterface userService = new CustomerService();
    static Scanner obj = new Scanner(System.in);

    /**
     * Main method that starts the application.
     */
    public static void main(String[] args) {
        System.out.println("\nWELCOME TO FLIPFIT APPLICATION!\n");
        boolean exitFlag = false;
        
        // Main menu loop
        while (true) {
            // Displaying main menu options
            System.out.println("1. Login");
            System.out.println("2. Registration");
            System.out.println("3. Change Password");
            System.out.println("4. Exit");
            int choice = obj.nextInt();
            obj.nextLine();
            
            switch (choice) {
                case 1:
                    login(); // Calling login method
                    break;
                case 2:
                    registration(); // Calling registration method
                    break;
                case 3:
                    changePassword(); // Calling changePassword method
                    break;
                case 4:
                    exitFlag = true; // Setting exitFlag to true to exit the main loop
                    System.out.println("Thank you for using FlipFit!!");
                    break;
                default:
                    System.out.println("\nInvalid Options Selected. Please Try Again:( \n");
                    break;
            }
            if (exitFlag) break; // Breaking out of the main loop if exitFlag is true
        }
    }

    /**
     * Method to handle user login based on role (Admin, Customer, Gym Owner).
     */
    private static void login() {
        System.out.println("Enter role \n1. Admin\n2. Customer\n3. Gym Owner\n");
        int role = obj.nextInt();
        obj.nextLine();
        System.out.println("Enter email:");
        String userId = obj.nextLine();
        System.out.println("Enter password:");
        String password = obj.nextLine();

        switch (role) {
            case 1:
                // Admin login handling
                GymFlipFitAdminMenu admin = new GymFlipFitAdminMenu();
                if (!admin.verifyAdminCredentials(userId, password)) {
                    System.out.println("\nInvalid Credentials\n");
                    break;
                }

                boolean adminFlag = true;
                while (adminFlag) {
                    // Admin menu options
                    System.out.println("\n\n --------------- Admin Menu Options --------------- ");
                    System.out.println("Gym Owner Options:");
                    System.out.println("\t1. View Pending Registration Request");
                    System.out.println("\t2. Approve Registration");
                    System.out.println("\t3. Approve ALL Pending Registration Requests");
                    System.out.println("Gym Options:");
                    System.out.println("\t4. View Pending Gym Registration");
                    System.out.println("\t5. Approve Gym Registration");
                    System.out.println("\t6. Approve ALL Gym Registration Requests");
                    System.out.println("7. Quit");
                    System.out.print("Enter your choice: ");

                    int choice = obj.nextInt();
                    obj.nextLine();

                    switch (choice) {
                        case 1:
                            admin.viewUnverifiedGymOwners(); // Viewing unverified gym owners
                            break;
                        case 2:
                            System.out.println("Enter the Gym Owner Id to be approved:");
                            int gymOwnerId = obj.nextInt();
                            obj.nextLine();
                            admin.verifyGymOwner(gymOwnerId); // Verifying a gym owner by ID
                            break;
                        case 3:
                            System.out.println("All pending gym owner registration requests have been approved.");
                            break;
                        case 4:
                            admin.viewUnverifiedGyms(); // Viewing unverified gyms
                            break;
                        case 5:
                            System.out.println("Enter the Gym Id to be approved:");
                            int gymId = obj.nextInt();
                            obj.nextLine();
                            admin.verifyGym(gymId); // Verifying a gym by ID
                            break;
                        case 6:
                            System.out.println("All pending gym center registration requests have been approved.");
                            break;
                        case 7:
                            adminFlag = false; // Exiting admin menu
                            break;
                        default:
                            System.out.println("\nInvalid Options Selected. Please Try Again:(\n");
                            break;
                    }
                }
                break;
            case 2:
                // Customer login handling
                if (!customer.userLogin(userId, password)) {
                    System.out.println("\nInvalid Credentials\n");
                }
                break;
            case 3:
                // Gym Owner login handling
                if (!owner.gymOwnerLogin(userId, password)) {
                    System.out.println("\nInvalid Credentials\n");
                }
                break;
            default:
                System.out.println("\nInvalid Options Selected. Please Try Again:(\n");
                break;
        }
    }

    /**
     * Method to handle user registration as Customer or Gym Owner.
     */
    private static void registration() {
        System.out.println("1. Register as a Customer");
        System.out.println("2. Register as a Gym Owner");
        System.out.println("3. Go Back");
        int choice = obj.nextInt();
        obj.nextLine();
        
        switch (choice) {
            case 1:
                customer.createCustomer(); // Calling method to register as a customer
                break;
            case 2:
                owner.createGymOwner(); // Calling method to register as a gym owner
                break;
            case 3:
                break; // Going back to the main menu
            default:
                System.out.println("\nInvalid Options Selected. Please Try Again:(\n");
                break;
        }
    }

    /**
     * Method to handle changing user passwords for Admin, Customer, or Gym Owner.
     */
    private static void changePassword() {
        System.out.println("----------------------Password Change-----------------\n");
        System.out.println("Enter email:");
        String user = obj.nextLine();
        System.out.println("Enter password:");
        String userPassword = obj.nextLine();
        System.out.println("Enter role \n1. Admin\n2. Customer\n3. Gym Owner\n");
        int respectiveRole = obj.nextInt();
        obj.nextLine();
        System.out.println("Enter New password:");
        String updatedPassword = obj.nextLine();

        switch (respectiveRole) {
            case 1:
                // Assuming admin password change logic here
                // adminService.updateAdminPassword(user, userPassword, updatedPassword);
                break;
            case 2:
                // Customer password change handling
                if (!customer.validateUser(user, userPassword)) {
                    System.out.println("\nInvalid Credentials\n");
                } else {
                    userService.updateGymUserPassword(user, userPassword, updatedPassword);
                }
                break;
            case 3:
                // Gym Owner password change handling
                if (!owner.verifyGymOwner(user, userPassword)) {
                    System.out.println("\nInvalid Credentials\n");
                } else {
                    gymOwnerService.updateGymOwnerPassword(user, userPassword, updatedPassword);
                }
                break;
            default:
                System.out.println("\nInvalid Options Selected. Please Try Again:(\n");
                break;
        }
    }
}
