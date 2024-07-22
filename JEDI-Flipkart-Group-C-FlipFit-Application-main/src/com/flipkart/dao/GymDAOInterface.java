package com.flipkart.dao;

import com.flipkart.bean.Gym;
import com.flipkart.bean.Slots;

import java.util.List;

/**
 * Interface defining methods to interact with the database for Gym and Slots entities.
 */
public interface GymDAOInterface {

    /**
     * Retrieves a list of Gym objects owned by the specified owner ID from the database.
     * @param ownerId The owner ID for which gyms are to be fetched.
     * @return List of Gym objects owned by the specified owner ID.
     */
    List<Gym> getGymsByOwnerId(String ownerId);

    /**
     * Adds a new Gym object to the database.
     * @param gym The Gym object to be added.
     */
    void addGym(Gym gym);

    /**
     * Inserts a list of Slots into the database for a specified gym ID.
     * @param slots The list of Slots to be inserted.
     * @param gymId The ID of the gym for which slots are to be inserted.
     */
    void insertSlots(List<Slots> slots, int gymId);
}
