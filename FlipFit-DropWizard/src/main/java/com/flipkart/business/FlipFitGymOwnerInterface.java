package com.flipkart.business;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slots;

import java.util.List;

// Interface for Gym Owner business logic
public interface FlipFitGymOwnerInterface {
    //Method to add a gym along with its slots.
    void addGymWithSlots(Gym gym);
    //Method to retrieve a list of gyms owned by a specific user.
    List<Gym> viewMyGyms(String userId);
    //Method to validate the login credentials of a gym owner.
    boolean validateLogin(String email, String password);
    //Method to create a new gym owner profile.
    void createGymOwner(GymOwner gymOwner);
    //Method to verify the password of a gym owner.
    boolean verifyGymOwnerPassword(String email, String password);
    //Method to update the password of a gym owner.
    void updateGymOwnerPassword(String email, String password, String updatedPassword);
    //Method to add slots to a gym.
    void addSlots(int gymId, List<Slots> slots);
    //Method to send a gym owner profile for approval.
    boolean sendProfileForApproval(String userId);
    //Method to get the owner ID by email.
    String getOwnerIdByEmail(String email);
}
