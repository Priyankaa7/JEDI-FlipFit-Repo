/*package com.flipkart.business;

import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.dao.AdminDAOImplementation;
import com.flipkart.dao.AdminDAOInterface;

public class AdminService implements AdminInterface {

	AdminDAOInterface adminDaoInterface = new AdminDAOImplementation();
	Scanner obj = new Scanner(System.in);

	@Override
	public void viewGymOwners() {
		adminDaoInterface.viewGymOwners();
	}

	@Override
	public void viewGyms() {
		adminDaoInterface.viewGyms();
	}

	@Override
	public void viewUsers() {
		adminDaoInterface.viewUsers();
	}

	@Override
	public void verifyGym(int gymId) {
		adminDaoInterface.verifyGyms(gymId);
	}

	@Override
	public void verifyGymOwner(int gymOwnerId) {
		adminDaoInterface.verifyGymOwners(gymOwnerId);
	}

	@Override
	public List<GymOwner> getUnverifiedGymOwners() {
		return adminDaoInterface.getUnverifiedGymOwner();
	}

	@Override
	public List<Gym> getUnverifiedGyms() {
		return adminDaoInterface.getUnverifiedGyms();
	}

}*/

// public class AdminService implements AdminInterface {

// 	AdminDAOInterface adminDaoInterface = new AdminDAOImplementation();
// 	Scanner obj = new Scanner(System.in);

// 	@Override
// 	public void viewGymOwners() {
// 		adminDaoInterface.viewGymOwners();
// 	}

// 	@Override
// 	public void viewGyms() {
// 		adminDaoInterface.viewGyms();
// 	}

// 	@Override
// 	public void viewUsers() {
// 		adminDaoInterface.viewUsers();
// 	}

// 	@Override
// 	public void verifyGym(int gymId) {
// 		adminDaoInterface.verifyGyms(gymId);
// 	}

// 	@Override
// 	public void verifyGymOwner(int gymOwnerId) {
// 		adminDaoInterface.verifyGymOwners(gymOwnerId);
// 	}

// 	@Override
// 	public List<GymOwner> getUnverifiedGymOwners() {
// 		return adminDaoInterface.getUnverifiedGymOwner();
// 	}

// 	@Override
// 	public List<Gym> getUnverifiedGyms() {
// 		return adminDaoInterface.getUnverifiedGyms();
// 	}
// }



package com.flipkart.business;

import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.dao.AdminDAOImplementation;
import com.flipkart.dao.AdminDAOInterface;

// AdminService class implements the AdminInterface and provides functionality for admin operations
public class AdminService implements AdminInterface {

	// Instance variables
	AdminDAOInterface adminDaoInterface = new AdminDAOImplementation(); // Using AdminDAOImplementation for data access
	Scanner obj = new Scanner(System.in); // Scanner object for user input
	@Override
	public void viewGymOwners() {
		adminDaoInterface.viewGymOwners(); // Delegates to AdminDAOInterface for viewing gym owners
	}
	@Override
	public void viewGyms() {
		adminDaoInterface.viewGyms(); // Delegates to AdminDAOInterface for viewing gyms
	}
	@Override
	public void viewUsers() {
		adminDaoInterface.viewUsers(); // Delegates to AdminDAOInterface for viewing users (not implemented in provided DAO)
	}
	@Override
	public void verifyGym(int gymId) {
		adminDaoInterface.verifyGyms(gymId); // Delegates to AdminDAOInterface for verifying a gym by ID
	}
	@Override
	public void verifyGymOwner(int gymOwnerId) {
		adminDaoInterface.verifyGymOwners(gymOwnerId); // Delegates to AdminDAOInterface for verifying a gym owner by ID
	}
	@Override
	public List<GymOwner> getUnverifiedGymOwners() {
		return adminDaoInterface.getUnverifiedGymOwner(); // Retrieves unverified gym owners using AdminDAOInterface
	}
	@Override
	public List<Gym> getUnverifiedGyms() {
		return adminDaoInterface.getUnverifiedGyms(); // Retrieves unverified gyms using AdminDAOInterface
	}
}

