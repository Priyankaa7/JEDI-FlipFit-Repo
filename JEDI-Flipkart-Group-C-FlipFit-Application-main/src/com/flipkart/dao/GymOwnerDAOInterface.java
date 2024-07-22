package com.flipkart.dao;

import com.flipkart.bean.GymOwner;

public interface GymOwnerDAOInterface {
    void newGymOwner(GymOwner gymOwner);
    boolean verifyGymOwnerPassword(String email, String password);
    boolean sendProfileForApproval(String ownerId);
    void updateGymOwnerPassword(String email, String password, String updatedPassword);
    String getOwnerIdByEmail(String email);  // New method to fetch ownerId by email
}
