/*package com.flipkart.business;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.bean.User;
import com.flipkart.dao.CustomerDAOImplementation;
import com.flipkart.dao.CustomerDAOInterface;

public class CustomerService implements CustomerInterface {

	CustomerDAOInterface customerDAOInterface = new CustomerDAOImplementation();

	@Override
	public boolean verifyGymUserPassword(String email, String password, String updatedPassword) {
		return false;
	}

	@Override
	public boolean cancelSlots(int bookingId) {
		return customerDAOInterface.cancelBooking(bookingId);
	}

	@Override
	public List<Bookings> getAllBookings(String userId) {
		return customerDAOInterface.getAllBookingByUserID(userId);
	}

	@Override
	public List<Gym> getAllGymsWithSlots() {
		return customerDAOInterface.getAllGyms();
	}

	@Override
	public List<Gym> getAllGymsByArea(String area) {
		List<Gym> allGyms = customerDAOInterface.getAllGyms();
		List<Gym> filteredGyms = new ArrayList<>();
		for (Gym gym : allGyms) {
			if (gym.getLocation() != null && gym.getLocation().equals(area)) {
				filteredGyms.add(gym);
			}
		}
		return filteredGyms;
	}

	@Override
	public boolean bookSlots(int gymId, int time, String email) {
		return customerDAOInterface.bookSlot(gymId, time, email);
	}

	@Override
	public boolean validateUser(String username, String pass) {
		return customerDAOInterface.validateUser(username, pass);
	}

	@Override
	public void createUser(User user) {
		customerDAOInterface.createUser(user);
	}

	@Override
	public void updateGymUserPassword(String email, String password, String updatedPassword) {
		customerDAOInterface.updateGymUserPassword(email, password, updatedPassword);
	}

}*/

/*package com.flipkart.business;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.bean.User;
import com.flipkart.dao.CustomerDAOImplementation;
import com.flipkart.dao.CustomerDAOInterface;

import java.util.ArrayList;
import java.util.List;

public class CustomerService implements CustomerInterface {

	CustomerDAOInterface customerDAOInterface = new CustomerDAOImplementation();

	@Override
	public boolean verifyGymUserPassword(String email, String password, String updatedPassword) {
		return false;
	}

	@Override
	public boolean cancelSlots(int bookingId) {
		return customerDAOInterface.cancelBooking(bookingId);
	}

	@Override
	public List<Bookings> getAllBookings(String userId) {
		return customerDAOInterface.getAllBookingByUserID(userId);
	}

	@Override
	public List<Gym> getAllGymsWithSlots() {
		return customerDAOInterface.getAllGyms();
	}

	@Override
	public List<Gym> getAllGymsByArea(String area) {
		List<Gym> filteredGyms = customerDAOInterface.getAllGyms();

		return filteredGyms;
	}

	@Override
	public boolean bookSlots(int gymId, String time, String email) {
		return customerDAOInterface.bookSlot(gymId, time, email);
	}

	@Override
	public boolean validateUser(String username, String pass) {

		return customerDAOInterface.validateUser(username, pass);
	}

	@Override
	public void createUser(User user) {
		customerDAOInterface.createUser(user);
	}

	@Override
	public void updateGymUserPassword(String email, String password, String updatedPassword) {
		customerDAOInterface.updateGymUserPassword(email, password, updatedPassword);
	}

	@Override
	public User getUserProfile(String email) {
		return customerDAOInterface.getUserByEmail(email);
	}
}
*/

// public class CustomerService implements CustomerInterface {

// 	CustomerDAOInterface customerDAOInterface = new CustomerDAOImplementation();

// 	@Override
// 	public boolean verifyGymUserPassword(String email, String password, String updatedPassword) {
// 		return false;
// 	}

// 	@Override
// 	public boolean cancelSlots(int bookingId) {
// 		return customerDAOInterface.cancelBooking(bookingId);
// 	}

// 	@Override
// 	public List<Bookings> getAllBookings(String username) {
// 		return customerDAOInterface.getAllBookingByUserID(username);
// 	}

// 	@Override
// 	public List<Gym> getAllGymsWithSlots() {
// 		return customerDAOInterface.getAllGyms();
// 	}

// 	@Override
// 	public List<Gym> getAllGymsByArea(String area) {
// 		List<Gym> filteredGyms = customerDAOInterface.getAllGyms();
// 		// Filter gyms by area if needed
// 		return filteredGyms;
// 	}

// 	@Override
// 	public boolean bookSlots(int gymId, String time, String email) {
// 		return customerDAOInterface.bookSlot(gymId, time, email);
// 	}

// 	@Override
// 	public boolean validateUser(String username, String pass) {
// 		return customerDAOInterface.validateUser(username, pass);
// 	}

// 	@Override
// 	public void createUser(User user) {
// 		customerDAOInterface.createUser(user);
// 	}

// 	@Override
// 	public void updateGymUserPassword(String email, String password, String updatedPassword) {
// 		customerDAOInterface.updateGymUserPassword(email, password, updatedPassword);
// 	}

// 	@Override
// 	public User getUserProfile(String email) {
// 		return customerDAOInterface.getUserByEmail(email);
// 	}
// }

package com.flipkart.business;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.bean.User;
import com.flipkart.dao.CustomerDAOImplementation;
import com.flipkart.dao.CustomerDAOInterface;

import java.util.ArrayList;
import java.util.List;

public class CustomerService implements CustomerInterface {

    // Instantiate CustomerDAOImplementation to interact with data access layer
    CustomerDAOInterface customerDAOInterface = new CustomerDAOImplementation();

    // Method to verify gym user password (currently not implemented)
    @Override
    public boolean verifyGymUserPassword(String email, String password, String updatedPassword) {
        return false; // Placeholder implementation
    }

    // Method to cancel slots using CustomerDAOInterface
    @Override
    public boolean cancelSlots(int bookingId) {
        return customerDAOInterface.cancelBooking(bookingId);
    }

    // Method to retrieve all bookings for a given username
    @Override
    public List<Bookings> getAllBookings(String username) {
        return customerDAOInterface.getAllBookingByUserID(username);
    }

    // Method to retrieve all gyms with available slots
    @Override
    public List<Gym> getAllGymsWithSlots() {
        return customerDAOInterface.getAllGyms();
    }

    // Method to retrieve all gyms in a specific area (currently returns all gyms)
    @Override
    public List<Gym> getAllGymsByArea(String area) {
        List<Gym> filteredGyms = customerDAOInterface.getAllGyms();
        // Filter gyms by area if needed (currently returns all gyms)
        return filteredGyms;
    }

    // Method to book slots at a specific gym using CustomerDAOInterface
    @Override
    public boolean bookSlots(int gymId, String time, String email) {
        return customerDAOInterface.bookSlot(gymId, time, email);
    }

    // Method to validate user credentials using CustomerDAOInterface
    @Override
    public boolean validateUser(String username, String pass) {
        return customerDAOInterface.validateUser(username, pass);
    }

    // Method to create a new user using CustomerDAOInterface
    @Override
    public void createUser(User user) {
        customerDAOInterface.createUser(user);
    }

    // Method to update gym user password using CustomerDAOInterface
    @Override
    public void updateGymUserPassword(String email, String password, String updatedPassword) {
        customerDAOInterface.updateGymUserPassword(email, password, updatedPassword);
    }

    // Method to retrieve user profile based on email using CustomerDAOInterface
    @Override
    public User getUserProfile(String email) {
        return customerDAOInterface.getUserByEmail(email);
    }
}

