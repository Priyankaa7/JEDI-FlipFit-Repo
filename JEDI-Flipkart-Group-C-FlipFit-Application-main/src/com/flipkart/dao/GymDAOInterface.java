package com.flipkart.dao;

import com.flipkart.bean.Gym;
import com.flipkart.bean.Slots;

import java.util.List;

public interface GymDAOInterface {
    List<Gym> getGymsByOwnerId(String ownerId);
    void addGym(Gym gym);
    void insertSlots(List<Slots> slots, int gymId);
}
