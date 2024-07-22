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

package com.flipkart.business;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.bean.User;

import java.util.List;

public interface CustomerInterface {
	boolean verifyGymUserPassword(String email, String password, String updatedPassword);

	boolean cancelSlots(int bookingId);

	List<Bookings> getAllBookings(String userId);

	List<Gym> getAllGymsWithSlots();

	List<Gym> getAllGymsByArea(String area);

	boolean bookSlots(int gymId, String time, String email);

	boolean validateUser(String username, String pass);

	void createUser(User user);

	void updateGymUserPassword(String email, String password, String updatedPassword);

	User getUserProfile(String email);
}

