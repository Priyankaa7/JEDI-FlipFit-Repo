package com.flipkart.business;

import com.flipkart.bean.Gym;
import com.flipkart.dao.GymDAOInterface;
import com.flipkart.dao.GymDAOImplementation;

import java.util.List;

// Service class implementing GymInterface
public class FlipFitGymService implements FlipFitGymInterface {

    // DAO instance to interact with the database
    private GymDAOInterface gymDAO = new GymDAOImplementation();

    // Method to retrieve a list of gyms owned by a specific owner.
    @Override
    public List<Gym> getGymsByOwnerId(String ownerId) {
        // Delegate the call to the DAO layer
        return gymDAO.getGymsByOwnerId(ownerId);
    }
}
