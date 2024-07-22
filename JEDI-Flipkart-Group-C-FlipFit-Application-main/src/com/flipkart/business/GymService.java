package com.flipkart.business;

import com.flipkart.bean.Gym;
import com.flipkart.dao.GymDAOInterface;
import com.flipkart.dao.GymDAOImplementation;

import java.util.List;

public class GymService implements GymInterface {

    private GymDAOInterface gymDAO = new GymDAOImplementation();

    @Override
    public List<Gym> getGymsByOwnerId(String ownerId) {
        return gymDAO.getGymsByOwnerId(ownerId);
    }
}
