package com.flipkart.business;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slots;
import com.flipkart.dao.GymDAOInterface;
import com.flipkart.dao.GymDAOImplementation;
import com.flipkart.dao.GymOwnerDAOInterface;
import com.flipkart.dao.GymOwnerDAOImplementation;

import java.util.List;

// Service class implementing GymOwnerInterface
public class FlipFitGymOwnerService implements FlipFitGymOwnerInterface {

    // DAO instances to interact with the database
    GymOwnerDAOInterface gymOwnerDAO = new GymOwnerDAOImplementation();
    GymDAOInterface gymDAO = new GymDAOImplementation();

    //Method to validate the login credentials of a gym owner.
    @Override
    public boolean validateLogin(String email, String password) {
        return gymOwnerDAO.verifyGymOwnerPassword(email, password);
    }

    //Method to add a gym along with its slots.
    @Override
    public void addGymWithSlots(Gym gym) {
        gymDAO.addGym(gym);
    }

    //Method to retrieve a list of gyms owned by a specific user.
    @Override
    public List<Gym> viewMyGyms(String ownerId) {
        return gymDAO.getGymsByOwnerId(ownerId);
    }

    //Method to create a new gym owner profile.
    @Override
    public void createGymOwner(GymOwner gymOwner) {
        gymOwnerDAO.newGymOwner(gymOwner);
    }

    //Method to verify the password of a gym owner.
    @Override
    public boolean verifyGymOwnerPassword(String email, String password) {
        return false;
    }

    //Method to update the password of a gym owner.
    @Override
    public void updateGymOwnerPassword(String email, String password, String updatedPassword) {

    }

    //Method to add slots to a gym.
    @Override
    public void addSlots(int gymId, List<Slots> slots) {
        gymDAO.insertSlots(slots, gymId);
    }

    //Method to send a gym owner profile for approval.
    @Override
    public boolean sendProfileForApproval(String ownerId) {
        return gymOwnerDAO.sendProfileForApproval(ownerId);
    }

    //Method to get the owner ID by email.
    @Override
    public String getOwnerIdByEmail(String email) {
        return gymOwnerDAO.getOwnerIdByEmail(email);
    }
}
