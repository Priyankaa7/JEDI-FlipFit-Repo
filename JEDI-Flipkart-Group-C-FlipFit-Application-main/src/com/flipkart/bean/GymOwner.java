package com.flipkart.bean;

import java.util.List;

/**
 * Represents a Gym Owner entity with details such as owner ID, email, password,
 * phone number, national ID, GST number, associated gyms, PAN number, owner name,
 * status, and verification status.
 */
public class GymOwner {

    private int ownerId;                // Unique identifier for the gym owner
    private String ownerEmail;          // Email address of the gym owner
    private String password;            // Password for the gym owner's account
    private String phoneNo;             // Phone number of the gym owner
    private String nationalId;          // National ID (e.g., Aadhaar card) of the gym owner
    private String GST;                 // GST number of the gym owner
    private List<Gym> gyms;             // List of gyms owned by the gym owner
    private String PAN;                 // PAN (Permanent Account Number) of the gym owner
    private String ownerName;           // Name of the gym owner
    private String status;              // Status of the gym owner (e.g., active, inactive)
    private String verificationStatus;  // Verification status of the gym owner (e.g., verified, pending)

    /**
     * Getter method for retrieving the owner ID.
     * @return The owner ID.
     */
    public int getOwnerId() {
        return ownerId;
    }

    /**
     * Setter method for setting the owner ID.
     * @param ownerId The owner ID to set.
     */
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * Getter method for retrieving the email address of the gym owner.
     * @return The email address of the gym owner.
     */
    public String getOwnerEmail() {
        return ownerEmail;
    }

    /**
     * Setter method for setting the email address of the gym owner.
     * @param ownerEmail The email address to set.
     */
    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    /**
     * Getter method for retrieving the password of the gym owner's account.
     * @return The password of the gym owner's account.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for setting the password of the gym owner's account.
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter method for retrieving the phone number of the gym owner.
     * @return The phone number of the gym owner.
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * Setter method for setting the phone number of the gym owner.
     * @param phoneNo The phone number to set.
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * Getter method for retrieving the national ID of the gym owner.
     * @return The national ID of the gym owner.
     */
    public String getNationalId() {
        return nationalId;
    }

    /**
     * Setter method for setting the national ID of the gym owner.
     * @param nationalId The national ID to set.
     */
    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    /**
     * Getter method for retrieving the GST number of the gym owner.
     * @return The GST number of the gym owner.
     */
    public String getGST() {
        return GST;
    }

    /**
     * Setter method for setting the GST number of the gym owner.
     * @param GST The GST number to set.
     */
    public void setGST(String GST) {
        this.GST = GST;
    }

    /**
     * Getter method for retrieving the list of gyms owned by the gym owner.
     * @return The list of gyms owned.
     */
    public List<Gym> getGyms() {
        return gyms;
    }

    /**
     * Setter method for setting the list of gyms owned by the gym owner.
     * @param gyms The list of gyms to set.
     */
    public void setGyms(List<Gym> gyms) {
        this.gyms = gyms;
    }

    /**
     * Getter method for retrieving the PAN (Permanent Account Number) of the gym owner.
     * @return The PAN of the gym owner.
     */
    public String getPAN() {
        return PAN;
    }

    /**
     * Setter method for setting the PAN (Permanent Account Number) of the gym owner.
     * @param PAN The PAN to set.
     */
    public void setPAN(String PAN) {
        this.PAN = PAN;
    }

    /**
     * Getter method for retrieving the name of the gym owner.
     * @return The name of the gym owner.
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Setter method for setting the name of the gym owner.
     * @param ownerName The name to set.
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    /**
     * Getter method for retrieving the status of the gym owner.
     * @return The status of the gym owner.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Setter method for setting the status of the gym owner.
     * @param status The status to set.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Getter method for retrieving the verification status of the gym owner.
     * @return The verification status of the gym owner.
     */
    public String getVerificationStatus() {
        return verificationStatus;
    }

    /**
     * Setter method for setting the verification status of the gym owner.
     * @param verificationStatus The verification status to set.
     */
    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
    }
}
