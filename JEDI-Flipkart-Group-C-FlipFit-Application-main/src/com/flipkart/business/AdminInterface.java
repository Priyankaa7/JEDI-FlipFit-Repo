package com.flipkart.business;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import java.util.List;

// AdminInterface defines the methods that an admin of the system can perform
public interface AdminInterface {
    // Method to view all registered gym owners
    public void viewGymOwners();
    // Method to view all registered gyms
    public void viewGyms();
    // Method to view all registered users (not implemented here, assumed to be users of the gyms)
    public void viewUsers();
    // Method to verify a specific gym by its ID
    public void verifyGym(int gymId);
    // Method to verify a specific gym owner by their ID
    public void verifyGymOwner(int gymOwnerId);
    // Method to retrieve a list of gym owners who are yet to be verified
    public List<GymOwner> getUnverifiedGymOwners();
    // Method to retrieve a list of gyms that are yet to be verified
    public List<Gym> getUnverifiedGyms();
}

