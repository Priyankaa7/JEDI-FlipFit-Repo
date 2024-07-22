package com.flipkart.bean;

public class Slots {

	private int slotsId;
	private String timeSlot; // Changed to String
	private int seatCount;

	public Slots(int slotsId, String timeSlot, int seatCount) {
		this.setSlotsId(slotsId);
		this.setTimeSlot(timeSlot);
		this.setSeatCount(seatCount);
	}

	public int getSlotsId() {
		return slotsId;
	}

	public void setSlotsId(int slotsId) {
		this.slotsId = slotsId;
	}

	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}
}
