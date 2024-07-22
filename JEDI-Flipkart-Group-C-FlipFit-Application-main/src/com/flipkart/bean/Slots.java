package com.flipkart.bean;

/**
 * Represents a time slot entity with details such as slot ID, time slot description,
 * and seat count.
 */
public class Slots {

    private int slotsId;        // Unique identifier for the time slot
    private String timeSlot;    // Description of the time slot (e.g., "9:00 AM - 10:00 AM")
    private int seatCount;      // Number of seats available in the time slot

    /**
     * Constructor to initialize a Slots object with specified values.
     * @param slotsId The unique identifier for the time slot.
     * @param timeSlot The description of the time slot.
     * @param seatCount The number of seats available in the time slot.
     */
    public Slots(int slotsId, String timeSlot, int seatCount) {
        this.setSlotsId(slotsId);
        this.setTimeSlot(timeSlot);
        this.setSeatCount(seatCount);
    }

    /**
     * Getter method for retrieving the slot ID.
     * @return The slot ID.
     */
    public int getSlotsId() {
        return slotsId;
    }

    /**
     * Setter method for setting the slot ID.
     * @param slotsId The slot ID to set.
     */
    public void setSlotsId(int slotsId) {
        this.slotsId = slotsId;
    }

    /**
     * Getter method for retrieving the description of the time slot.
     * @return The description of the time slot.
     */
    public String getTimeSlot() {
        return timeSlot;
    }

    /**
     * Setter method for setting the description of the time slot.
     * @param timeSlot The description of the time slot to set.
     */
    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    /**
     * Getter method for retrieving the number of seats available in the time slot.
     * @return The number of seats available.
     */
    public int getSeatCount() {
        return seatCount;
    }

    /**
     * Setter method for setting the number of seats available in the time slot.
     * @param seatCount The number of seats available to set.
     */
    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }
}
