package com.flipkart.business;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slots;

import java.util.List;

public interface GymOwnerInterface {
    void addGymWithSlots(Gym gym);
    List<Gym> viewMyGyms(String userId);
    boolean validateLogin(String email, String password);
    void createGymOwner(GymOwner gymOwner);
    boolean verifyGymOwnerPassword(String email, String password);
    void updateGymOwnerPassword(String email, String password, String updatedPassword);
    void addSlots(int gymId, List<Slots> slots);  // New method for adding slots
    boolean sendProfileForApproval(String userId);  // New method for sending profile for approval
    String getOwnerIdByEmail(String email);
}
