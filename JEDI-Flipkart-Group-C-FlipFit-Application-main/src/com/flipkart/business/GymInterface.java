package com.flipkart.business;

import com.flipkart.bean.Gym;

import java.util.List;

public interface GymInterface {
    List<Gym> getGymsByOwnerId(String ownerId);
}
