package com.flipkart.bean;

/**
 * Represents a User entity with basic information such as user ID, username,
 * phone number, address, email, and password.
 */
public class User {

    private int userId;             // Unique identifier for the user
    private String userName;        // Username of the user
    private String phoneNumber;     // Phone number of the user
    private String address;         // Address of the user
    private String email;           // Email address of the user
    private String password;        // Password for the user's account

    /**
     * Getter method for retrieving the user ID.
     * @return The user ID.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Setter method for setting the user ID.
     * @param userId The user ID to set.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Getter method for retrieving the username.
     * @return The username.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Setter method for setting the username.
     * @param userName The username to set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Getter method for retrieving the email address of the user.
     * @return The email address of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for setting the email address of the user.
     * @param email The email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter method for retrieving the phone number of the user.
     * @return The phone number of the user.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Setter method for setting the phone number of the user.
     * @param phoneNumber The phone number to set.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter method for retrieving the address of the user.
     * @return The address of the user.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter method for setting the address of the user.
     * @param address The address to set.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Getter method for retrieving the password of the user's account.
     * @return The password of the user's account.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for setting the password of the user's account.
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
