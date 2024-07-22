/*package com.flipkart.constants;

public class SQLConstants {

    public static final String GYM_OWNER_INSERT_GYM = "INSERT INTO gyms (gymAddress, location, gymName, status, ownerId) VALUES(?,?,?,?,?)";

    public static final String GYM_OWNER_VIEW_GYM = "SELECT * FROM gym";

    public static final String GYM_USER_UPDATE_PASSWORD = "UPDATE User SET password = ? WHERE email = ? AND password = ?";

    public static final String GYM_OWNER_UPDATE_PASSWORD = "UPDATE GymOwners SET password = ? WHERE ownerEmail = ? AND password = ?";

    public static final String GYM_USER_VERIFY_PASSWORD = "SELECT * FROM GymOwners WHERE ownerEmail = ? AND password = ?";

    public static final String GYM_OWNER_VERIFY_PASSWORD = "SELECT * FROM GymOwners WHERE ownerEmail = ? AND password = ?";

    public static final String ADMIN_VIEW_ALL_USERS = "SELECT * FROM User";

    public static final String ADMIN_VIEW_ALL_GYMS = "SELECT * FROM gyms";

    public static final String ADMIN_VIEW_ALL_GYMOWNERS = "SELECT * FROM GymOwners";

    public static final String ADMIN_VERIFY_GYMS = "UPDATE gyms SET status = ? WHERE gymId = ?";

    public static final String ADMIN_VERIFY_GYMOWNERS = "UPDATE GymOwners SET status = ? WHERE ownerId = ?";

    public static final String ADMIN_VIEW_UNVERIFIED_GYMS = "SELECT * FROM gyms WHERE status=?";

    public static final String ADMIN_VIEW_UNVERIFIED_GYMOWNER = "SELECT * FROM GymOwners WHERE status=?";

    public static final String GYM_OWNER_INSERT = "INSERT INTO GymOwners (ownerEmail, ownerName, password, phoneNo, PAN, nationalId, GST, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
}*/

package com.flipkart.constants;

public class SQLConstants {

    public static final String GYM_OWNER_INSERT_GYM = "INSERT INTO Gyms (gymAddress, gymName, ownerId) VALUES(?,?,?)";

    public static final String GYM_OWNER_VIEW_GYM = "SELECT * FROM Gyms WHERE owner_id = ?";

    public static final String GYM_USER_UPDATE_PASSWORD = "UPDATE User SET password = ? WHERE email = ? AND Password = ?";

    public static final String GYM_OWNER_UPDATE_PASSWORD = "UPDATE GymOwners SET password = ? WHERE ownerEmail = ? AND Password = ?";

    public static final String GYM_USER_VERIFY_PASSWORD = "SELECT * FROM GymOwners WHERE ownerEmail = ? AND Password = ?";

    public static final String GYM_OWNER_VERIFY_PASSWORD = "SELECT * FROM GymOwners WHERE email = ? AND password = ?";

    public static final String ADMIN_VIEW_ALL_USERS = "SELECT * FROM User";

    public static final String ADMIN_VIEW_ALL_GYMS = "SELECT * FROM Gyms";

    public static final String ADMIN_VIEW_ALL_GYMOWNERS = "SELECT * FROM GymOwners";

    public static final String ADMIN_VERIFY_GYMS = "UPDATE Gyms SET status = ? WHERE gym_id = ?";

    public static final String ADMIN_VERIFY_GYMOWNERS = "UPDATE GymOwners SET status = ? WHERE owner_Id = ?";

    public static final String ADMIN_VIEW_UNVERIFIED_GYMS = "SELECT * FROM Gyms WHERE status=?";

    public static final String ADMIN_VIEW_UNVERIFIED_GYMOWNER = "SELECT * FROM GymOwners WHERE status=?";

    public static final String GYM_OWNER_INSERT = "INSERT INTO GymOwners (email, name, password, phone_number, pan, aadhar, gst, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
}
