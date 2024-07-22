package com.flipkart.bean;

// Customer class inheriting from User class
public class Customer extends User {

    // Private member variables specific to Customer
    private int membershipId; // Unique ID for customer's membership
    private String membershipType; // Type of membership (e.g., Gold, Silver)

    // Getter method for retrieving membership ID
    public int getMembershipId() {
        return membershipId;
    }

    // Setter method for setting membership ID
    public void setMembershipId(int membershipId) {
        this.membershipId = membershipId;
    }

    // Getter method for retrieving membership type
    public String getMembershipType() {
        return membershipType;
    }

    // Setter method for setting membership type
    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

} // end of Customer class
