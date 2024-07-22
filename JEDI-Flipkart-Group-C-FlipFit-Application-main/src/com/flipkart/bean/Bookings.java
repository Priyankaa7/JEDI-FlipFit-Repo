package com.flipkart.bean;

import java.sql.Date; // Import Date class
import java.sql.Time; // Import Time class

public class Bookings {
	private int bookingId;
	private int userId;
	private Date date; // Changed to Date
	private Time time; // Changed to Time
	private String slotId;
	private int gymId;
	private String status;

	public Date getDate() { // Changed to Date
		return date;
	}

	public void setDate(Date date) { // Changed to Date
		this.date = date;
	}

	public String getSlotId() {
		return slotId;
	}

	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}

	public int getGymId() {
		return gymId;
	}

	public void setGymId(int gymId) {
		this.gymId = gymId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Time getTime() { // Changed to Time
		return time;
	}

	public void setTime(Time time) { // Changed to Time
		this.time = time;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
