/*
 * GymOwnerDAOInterface
 * 
 * defines methods for interacting with the database to manage Gym Owner operations
 */
     
package com.flipkart.dao;

import com.flipkart.bean.GymOwner;

public interface GymOwnerDAOInterface {
      // Insert a new Gym Owner record into the database
    void newGymOwner(GymOwner gymOwner);
    // Verify the password of a Gym Owner against stored credentials
    boolean verifyGymOwnerPassword(String email, String password);
    // Update the status of a Gym Owner's profile to 'Pending' for approval
    boolean sendProfileForApproval(String ownerId);
     // Update the password of a Gym Owner in the database
    void updateGymOwnerPassword(String email, String password, String updatedPassword);
     // Retrieve the owner ID associated with a Gym Owner's email
    String getOwnerIdByEmail(String email);  // New method to fetch ownerId by email
}
