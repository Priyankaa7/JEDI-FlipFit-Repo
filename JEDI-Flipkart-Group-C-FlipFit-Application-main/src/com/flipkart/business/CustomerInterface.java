/*package com.flipkart.business;

import java.util.List;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.bean.User;

public interface CustomerInterface {

	boolean cancelSlots(int slotId);

	List<Bookings> getAllBookings(String userId);

	List<Gym> getAllGymsWithSlots();

	List<Gym> getAllGymsByArea(String area);

	boolean bookSlots(int gymId, int time, String email);

	boolean validateUser(String username, String pass);

	void createUser(User user);

	boolean verifyGymUserPassword(String email, String password, String updatedPassword);

	void updateGymUserPassword(String email, String password, String updatedPassword);
}*/

// package com.flipkart.business;

// import com.flipkart.bean.Bookings;
// import com.flipkart.bean.Gym;
// import com.flipkart.bean.User;

// import java.util.List;

// public interface CustomerInterface {
// 	boolean verifyGymUserPassword(String email, String password, String updatedPassword);

// 	boolean cancelSlots(int bookingId);

// 	List<Bookings> getAllBookings(String userId);

// 	List<Gym> getAllGymsWithSlots();

// 	List<Gym> getAllGymsByArea(String area);

// 	boolean bookSlots(int gymId, String time, String email);

// 	boolean validateUser(String username, String pass);

// 	void createUser(User user);

// 	void updateGymUserPassword(String email, String password, String updatedPassword);

// 	User getUserProfile(String email);
// }

package com.flipkart.business;
import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.bean.User;

import java.util.List;

// CustomerInterface defines methods for customer-related operations
public interface CustomerInterface {

    // Method to verify gym user password and optionally update it
    boolean verifyGymUserPassword(String email, String password, String updatedPassword);
    // Method to cancel slots for a booking identified by bookingId
    boolean cancelSlots(int bookingId);
    // Method to retrieve all bookings for a user identified by userId
    List<Bookings> getAllBookings(String userId);
    // Method to retrieve all gyms along with available slots
    List<Gym> getAllGymsWithSlots();
    // Method to retrieve all gyms in a specific area
    List<Gym> getAllGymsByArea(String area);
    // Method to book slots at a gym identified by gymId, for a specified time and user email
    boolean bookSlots(int gymId, String time, String email);
    // Method to validate user credentials (username and password)
    boolean validateUser(String username, String pass);
    // Method to create a new user profile
    void createUser(User user);
    // Method to update gym user's password
    void updateGymUserPassword(String email, String password, String updatedPassword);
    // Method to retrieve user profile based on email
    User getUserProfile(String email);
}


