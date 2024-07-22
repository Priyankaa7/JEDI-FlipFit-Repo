/**
 * Interface for Admin Data Access Object (DAO) operations.
 */
package com.flipkart.dao;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;

import java.sql.SQLException;
import java.util.List;

public interface AdminDAOInterface {
    /**
     * Retrieves and displays all gyms from the database.
     */
    public void viewGyms();
    /**
     * Retrieves and displays all users from the database.
     */
    public void viewUsers();
    /**
     * Retrieves and displays all gym owners from the database.
     */
    public void viewGymOwners();
    /**
     * Verifies a gym with the specified ID by updating its verification status in the database.
     *
     * @param id The ID of the gym to verify.
     */
    public void verifyGymOwners(int id);
    /**
     * Verifies a gym with the specified ID by updating its verification status in the database.
     *
     * @param id The ID of the gym to verify.
     */
    public void verifyGyms(int id);
    /**
     * Retrieves all unverified gyms from the database.
     *
     * @return A list of unverified gyms.
     */
    public List<Gym> getUnverifiedGyms();
    /**
     * Retrieves all unverified gym owners from the database.
     *
     * @return A list of unverified gym owners.
     */
    public List<GymOwner> getUnverifiedGymOwner();
}
