/*package com.flipkart.dao;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.bean.User;

import java.util.List;

public interface CustomerDAOInterface {
    public void updateGymUserPassword(String email,String password, String updatedPassword);
    public boolean verifyGymUserPassword(String email, String password);
    List<Gym> getAllGyms();
    boolean bookSlot(int gymId, int time, String email);
    List<Bookings> getAllBookingByUserID(String userId);
    boolean cancelBooking(int bookingId);
    boolean validateUser(String username, String pass);
    void createUser(User user);
}*/

/*
 * CustomerDAOInterface
 * 
 * defines methods to interact with the database for managing gym bookings and user credentials.
 */

package com.flipkart.dao;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.bean.User;

import java.util.List;

public interface CustomerDAOInterface {
     // Update gym user's password in the database
    void updateGymUserPassword(String email, String password, String updatedPassword);
    // Verify gym user's password against stored credentials
    boolean verifyGymUserPassword(String email, String password);
     // Retrieve a list of all gyms from the database
    List<Gym> getAllGyms();
    // Book a slot at a gym for a user
    boolean bookSlot(int gymId, String time, String email);
    // Retrieve all bookings made by a user using their user ID
    List<Bookings> getAllBookingByUserID(String userId);
    // Cancel a booking using its unique booking ID
    boolean cancelBooking(int bookingId);
    // Validate a user's credentials during login
    boolean validateUser(String username, String pass);
    // Create a new user record in the database
    void createUser(User user);
     // Retrieve user details based on their email address
    User getUserByEmail(String email);  // New method
}

