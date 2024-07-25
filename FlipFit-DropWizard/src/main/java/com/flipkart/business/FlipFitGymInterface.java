package com.flipkart.business;

import com.flipkart.bean.Gym;

import java.util.List;

// Interface for Gym business logic
public interface FlipFitGymInterface {
    /**
     * Method to retrieve a list of gyms by owner ID.
     *
     * @param ownerId The ID of the gym owner.
     * @return A list of Gym objects associated with the given owner ID.
     */
    List<Gym> getGymsByOwnerId(String ownerId);
}
