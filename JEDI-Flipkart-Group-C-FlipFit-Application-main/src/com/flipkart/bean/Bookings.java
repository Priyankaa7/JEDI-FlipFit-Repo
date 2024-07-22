package com.flipkart.bean;

import java.sql.Date; // Import Date class
import java.sql.Time; // Import Time class

// Class representing a booking entity
public class Bookings {

    // Private member variables to store booking details
    private int bookingId;
    private int userId;
    private Date date; // Date of the booking
    private Time time; // Time of the booking
    private String slotId; // Slot ID for the booking
    private int gymId; // ID of the gym where the booking is made
    private String status; // Status of the booking (e.g., confirmed, canceled)

    // Getter method for retrieving the booking date
    public Date getDate() {
        return date;
    }

    // Setter method for setting the booking date
    public void setDate(Date date) {
        this.date = date;
    }

    // Getter method for retrieving the slot ID
    public String getSlotId() {
        return slotId;
    }

    // Setter method for setting the slot ID
    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    // Getter method for retrieving the gym ID
    public int getGymId() {
        return gymId;
    }

    // Setter method for setting the gym ID
    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

    // Getter method for retrieving the booking status
    public String getStatus() {
        return status;
    }

    // Setter method for setting the booking status
    public void 
