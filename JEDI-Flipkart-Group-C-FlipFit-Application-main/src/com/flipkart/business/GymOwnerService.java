package com.flipkart.business;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slots;
import com.flipkart.dao.GymDAOInterface;
import com.flipkart.dao.GymDAOImplementation;
import com.flipkart.dao.GymOwnerDAOInterface;
import com.flipkart.dao.GymOwnerDAOImplementation;

import java.util.List;

public class GymOwnerService implements GymOwnerInterface {

	GymOwnerDAOInterface gymOwnerDAO = new GymOwnerDAOImplementation();
	GymDAOInterface gymDAO = new GymDAOImplementation();

	@Override
	public boolean validateLogin(String email, String password) {
		return gymOwnerDAO.verifyGymOwnerPassword(email, password);
	}

	@Override
	public void addGymWithSlots(Gym gym) {
		gymDAO.addGym(gym);
	}

	@Override
	public List<Gym> viewMyGyms(String ownerId) {
		return gymDAO.getGymsByOwnerId(ownerId);
	}

	@Override
	public void createGymOwner(GymOwner gymOwner) {
		gymOwnerDAO.newGymOwner(gymOwner);
	}

	@Override
	public boolean verifyGymOwnerPassword(String email, String password) {
		return false;
	}

	@Override
	public void updateGymOwnerPassword(String email, String password, String updatedPassword) {

	}

	@Override
	public void addSlots(int gymId, List<Slots> slots) {
		gymDAO.insertSlots(slots, gymId);
	}

	@Override
	public boolean sendProfileForApproval(String ownerId) {
		return gymOwnerDAO.sendProfileForApproval(ownerId);
	}

	@Override
	public String getOwnerIdByEmail(String email) {
		return gymOwnerDAO.getOwnerIdByEmail(email);
	}
}
