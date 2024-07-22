package com.flipkart.bean;

import java.util.List;

/**
 * Represents a Gym entity with basic information and associated slots.
 * This class encapsulates details such as gym ID, name, address, owner ID, 
 * and a list of available slots.
 */
public class Gym {

    private int gymId;          // Unique identifier for the gym
    private String gymName;     // Name of the gym
    private String gymAddress;  // Address of the gym
    private List<Slots> slots;  // List of available slots in the gym
    private String ownerId;     // ID of the owner of the gym

    /**
     * Getter method for retrieving the owner ID of the gym.
     * @return The owner ID of the gym.
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * Setter method for setting the owner ID of the gym.
     * @param ownerId The owner ID to set.
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * Getter method for retrieving the list of slots available in the gym.
     * @return The list of slots available in the gym.
     */
    public List<Slots> getSlots() {
        return slots;
    }

    /**
     * Setter method for setting the list of slots available in the gym.
     * @param slots The list of slots to set.
     */
    public void setSlots(List<Slots> slots) {
        this.slots = slots;
    }

    /**
     * Getter method for retrieving the gym ID.
     * @return The gym ID.
     */
    public int getGymId() {
        return gymId;
    }

    /**
     * Setter method for setting the gym ID.
     * @param gymId The gym ID to set.
     */
    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

    /**
     * Getter method for retrieving the name of the gym.
     * @return The name of the gym.
     */
    public String getGymName() {
        return gymName;
    }

    /**
     * Setter method for setting the name of the gym.
     * @param gymName The name of the gym to set.
     */
    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    /**
     * Getter method for retrieving the address of the gym.
     * @return The address of the gym.
     */
    public String getGymAddress() {
        return gymAddress;
    }

    /**
     * Setter method for setting the address of the gym.
     * @param gymAddress The address of the gym to set.
     */
    public void setGymAddress(String gymAddress) {
        this.gymAddress = gymAddress;
    }

} // end of Gym class
