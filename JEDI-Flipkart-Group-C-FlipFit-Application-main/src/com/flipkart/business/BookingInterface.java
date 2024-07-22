// BookingInterface defines the methods related to booking operations
public interface BookingInterface {

    // Method to add a booking for a user with specified slot and gym
    public void addBooking(String userId, String slotId, String gymId);
    // Method to cancel a booking based on booking ID
    public void cancelBooking(String bookingId);
}
