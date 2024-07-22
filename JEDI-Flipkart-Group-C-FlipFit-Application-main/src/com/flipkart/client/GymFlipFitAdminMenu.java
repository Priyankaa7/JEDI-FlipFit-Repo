package com.flipkart.client;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.business.AdminService;
import com.flipkart.utils.JDBCConnection;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * The GymFlipFitAdminMenu class provides an administrative menu for managing gyms and gym owners.
 */
public class GymFlipFitAdminMenu {

    AdminService adminService = new AdminService(); // Instance of AdminService to interact with business logic.

    /**
     * Displays all gyms registered in the system.
     */
    public void viewGyms() {
        adminService.viewGyms(); // Calls AdminService method to view gyms.
    }

    /**
     * Displays all registered users in the system.
     */
    public void viewUsers() {
        adminService.viewUsers(); // Calls AdminService method to view users.
    }

    /**
     * Displays all gym owners registered in the system.
     */
    public void viewGymOwners() {
        adminService.viewGymOwners(); // Calls AdminService method to view gym owners.
    }

    /**
     * Verifies a gym identified by its unique ID.
     * @param id The ID of the gym to be verified.
     */
    public void verifyGym(int id) {
        adminService.verifyGym(id); // Calls AdminService method to verify a gym by ID.
    }

    /**
     * Verifies a gym owner identified by their unique ID.
     * @param id The ID of the gym owner to be verified.
     */
    public void verifyGymOwner(int id) {
        adminService.verifyGymOwner(id); // Calls AdminService method to verify a gym owner by ID.
    }

    /**
     * Displays details of all unverified gyms in a formatted table.
     */
    public void viewUnverifiedGyms() {
        List<Gym> gyms = adminService.getUnverifiedGyms(); // Retrieves unverified gyms from AdminService.
        String leftAlignFormat = "| %-5d | %-20s | %-5d | %-40s |%n"; // Format for displaying gym details.
        System.out.format("+-------------------------------------------------------------------------------------------------------------+\n");
        System.out.format("| %-5s | %-20s | %-5s | %-40s |%n", "No.", "Name", "Gym Id", "Address");
        System.out.format("+-------------------------------------------------------------------------------------------------------------+\n");

        int x = 1;
        for (Gym g : gyms) {
            // Display each gym's details in the formatted table.
            System.out.format(leftAlignFormat, x, g.getGymName(), g.getGymId(), g.getGymAddress());
            x++;
        }
        System.out.println("-------------------------------------------------------------");
    }

    /**
     * Displays details of all unverified gym owners.
     */
    public void viewUnverifiedGymOwners() {
        List<GymOwner> gymOwners = adminService.getUnverifiedGymOwners(); // Retrieves unverified gym owners from AdminService.
        int x = 1;
        for (GymOwner gymOwner : gymOwners) {
            // Display details of each unverified gym owner.
            System.out.println("GymOwner " + x + "-->   \nGym Owner Id " + gymOwner.getOwnerId() + "\nEmail: " + gymOwner.getOwnerEmail() + "\nPhone No: " + gymOwner.getPhoneNo() + "\nStatus:" + gymOwner.getStatus());
            x++;
            System.out.println("\n-------------------------------------------------------------");
        }
    }

    /**
     * Verifies admin credentials against stored credentials in a properties file.
     * @param id The admin ID to verify.
     * @param pass The admin password to verify.
     * @return true if admin credentials match; false otherwise.
     */
    public boolean verifyAdminCredentials(String id, String pass) {
        try {
            Properties prop = new Properties();
            // Loads properties file to get admin credentials.
            InputStream inputStream = JDBCConnection.class.getClassLoader().getResourceAsStream("./config.properties");
            prop.load(inputStream);
            String admin_id = prop.getProperty("admin_id");
            String admin_password = prop.getProperty("admin_password");

            // Compares provided credentials with stored admin credentials.
            return (id.equals(admin_id) && pass.equals(admin_password));
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Prints error message if there's an exception.
            return false; // Returns false if validation fails.
        }
    }
}
