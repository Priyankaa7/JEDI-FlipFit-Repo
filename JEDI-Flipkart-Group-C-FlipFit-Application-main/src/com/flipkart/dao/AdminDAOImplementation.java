/*package com.flipkart.dao;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;

import com.flipkart.exception.VerificationFailedException;

import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.JDBCConnection;

import java.sql.Connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAOImplementation implements AdminDAOInterface {
    JDBCConnection connector;
    Connection conn;

    @Override
    public void viewGyms() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = JDBCConnection.getConnection();
            String sqlQuery = SQLConstants.ADMIN_VIEW_ALL_GYMS;
            preparedStatement = conn.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("gymId");
                String ownerId = resultSet.getString("ownerId");
                String name = resultSet.getString("gymName");
                String gymAddress = resultSet.getString("gymAddress");
                String location = resultSet.getString("location");
                String status = resultSet.getString("status");

                // Print the data or perform any other operations you need
                System.out.println("Gym ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Owner Id : " + ownerId);
                System.out.println("Gym Address : " + gymAddress);
                System.out.println("Gym Location : " + location);
                System.out.println("Status of Gym(verified or not) : " + status);
                System.out.println("---------------------------------");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void viewUsers() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = JDBCConnection.getConnection();
//            System.out.println("Debug3");
            preparedStatement = conn.prepareStatement(SQLConstants.ADMIN_VIEW_ALL_USERS);

            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Debug");

            while (resultSet.next()) {
                int id = resultSet.getInt("userId");
                String phoneNo = resultSet.getString("phoneNumber");
                String name = resultSet.getString("userName");
                String address = resultSet.getString("Address");
                String loc = resultSet.getString("location");
                String email = resultSet.getString("email");

                // Print the data or perform any other operations you need
                System.out.println("User ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Phone No : " + phoneNo);
                System.out.println("Address : " + address);
                System.out.println("Email Id : " + email);

                System.out.println("Location : " + loc);
                System.out.println("---------------------------------");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void viewGymOwners() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {

            conn = JDBCConnection.getConnection();
            System.out.println("Debug3");
            preparedStatement = conn.prepareStatement(SQLConstants.ADMIN_VIEW_ALL_GYMOWNERS);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("owner_id");
                String phoneNo = resultSet.getString("phone_number");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String adhaar = resultSet.getString("aadhar");
                String pan = resultSet.getString("pancard");
                String statusGymOwner = resultSet.getString("status");

                // Print the data or perform any other operations you need
                System.out.println("Gym Owner ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Phone No : " + phoneNo);

                System.out.println("Email Id : " + email);
                System.out.println("Adhaar no : " + adhaar);
                System.out.println("PAN Card Number : " + pan);
                System.out.println("Status  of The Gym Owner : " + statusGymOwner);

                System.out.println("---------------------------------");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void verifyGymOwners(int id) {
        // update the gymOwner db's status as verified.
        conn = JDBCConnection.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            //TODO -> for each onwer, update their status as verified.
            String query = SQLConstants.ADMIN_VERIFY_GYMOWNERS;
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "verified");
            pstmt.setString(2, Integer.toString(id));
            int stats = pstmt.executeUpdate(); // execute update statement
            //conn.commit();

            if (stats > 0) {
                System.out.println("Verified GymOwner successfully");
            } else {
                throw new VerificationFailedException();
//                System.out.println("Gym Owner verification failed");
            }

            System.out.println("---------------------------------");

        }catch(VerificationFailedException ex){
            System.out.println("Gym Owner "+ex.getMessage());
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void verifyGyms(int id) {
        PreparedStatement preparedStatement = null;
        conn = JDBCConnection.getConnection();
        try {
            String query = SQLConstants.ADMIN_VERIFY_GYMS;
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "verified"); // set input parameter 1
            pstmt.setString(2, Integer.toString(id)); // set input parameter 2
            int stats = pstmt.executeUpdate(); // execute update statement
            if (stats > 0) {
                System.out.println("Verified Gym successfully");
            } else {
                throw new VerificationFailedException();
//                System.out.println("Gym Owner verification failed");
            }

            System.out.println("---------------------------------");

        }catch(VerificationFailedException ex){
            System.out.println("Gym "+ex.getMessage());
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }

    @Override
    public List<Gym> getUnverifiedGyms() {
        conn = JDBCConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Gym> gyms = new ArrayList<>();

        try {
            String sqlQuery = SQLConstants.ADMIN_VIEW_UNVERIFIED_GYMS;
            preparedStatement = conn.prepareStatement(sqlQuery);
            preparedStatement.setString(1, "Unverified");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("gymId");
                String gymAddress = resultSet.getString("gymAddress");
                String gymName = resultSet.getString("gymName");
                String gymOwnerID = resultSet.getString("ownerId");
                Gym gym = new Gym();
                gym.setGymId(id);
                gym.setGymName(gymName);
                gym.setGymAddress(gymAddress);
                gym.setOwnerId(gymOwnerID);
                gyms.add(gym);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return gyms;
    }

    @Override
    public List<GymOwner> getUnverifiedGymOwner() {
        Connection conn = JDBCConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<GymOwner> gymOwners = new ArrayList<>();

        try {
            String sqlQuery = "SELECT owner_id, name, email, phone_number, aadhar, gst FROM GymOwners WHERE status = ?";
            preparedStatement = conn.prepareStatement(sqlQuery);
            preparedStatement.setString(1, "Unverified");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("owner_id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String ph = resultSet.getString("phone_number");
                String nationalId = resultSet.getString("aadhar");
                String gst = resultSet.getString("gst");

                GymOwner x = new GymOwner();
                x.setOwnerId(id);
                x.setOwnerName(name);
                x.setOwnerEmail(email);
                x.setPhoneNo(ph);
                x.setNationalId(nationalId);
                x.setGST(gst);

                gymOwners.add(x);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            // Close resources to prevent memory leaks
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return gymOwners;
    }

}*/

package com.flipkart.dao;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.exception.VerificationFailedException;
import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Implementation of AdminDAOInterface for database operations related to admin tasks.
 */
public class AdminDAOImplementation implements AdminDAOInterface {
    JDBCConnection connector;
    Connection conn;

    @Override
    public void viewGyms() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = JDBCConnection.getConnection();
            String sqlQuery = SQLConstants.ADMIN_VIEW_ALL_GYMS;
            preparedStatement = conn.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("gym_id");
                String ownerId = resultSet.getString("owner_id");
                String name = resultSet.getString("gym_name");
                String gymAddress = resultSet.getString("gym_address");
                String location = resultSet.getString("location");
                String status = resultSet.getString("status");

                // Print the data or perform any other operations you need
                System.out.println("Gym ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Owner Id : " + ownerId);
                System.out.println("Gym Address : " + gymAddress);
                System.out.println("Gym Location : " + location);
                System.out.println("Status of Gym (verified or not) : " + status);
                System.out.println("---------------------------------");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void viewUsers() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = JDBCConnection.getConnection();
            preparedStatement = conn.prepareStatement(SQLConstants.ADMIN_VIEW_ALL_USERS);

            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Debug");

            while (resultSet.next()) {
                int id = resultSet.getInt("user_id");
                String phoneNo = resultSet.getString("phone_number");
                String name = resultSet.getString("user_name");
                String address = resultSet.getString("address");
                String loc = resultSet.getString("location");
                String email = resultSet.getString("email");

                // Print the data or perform any other operations you need
                System.out.println("User ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Phone No : " + phoneNo);
                System.out.println("Address : " + address);
                System.out.println("Email Id : " + email);
                System.out.println("Location : " + loc);
                System.out.println("---------------------------------");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void viewGymOwners() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = JDBCConnection.getConnection();
            preparedStatement = conn.prepareStatement(SQLConstants.ADMIN_VIEW_ALL_GYMOWNERS);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("owner_id");
                String phoneNo = resultSet.getString("phone_number");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String adhaar = resultSet.getString("aadhar");
                String pan = resultSet.getString("pancard");
                String statusGymOwner = resultSet.getString("status");

                // Print the data or perform any other operations you need
                System.out.println("Gym Owner ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Phone No : " + phoneNo);
                System.out.println("Email Id : " + email);
                System.out.println("Adhaar no : " + adhaar);
                System.out.println("PAN Card Number : " + pan);
                System.out.println("Status of The Gym Owner : " + statusGymOwner);
                System.out.println("---------------------------------");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void verifyGymOwners(int id) {
        conn = JDBCConnection.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String query = SQLConstants.ADMIN_VERIFY_GYMOWNERS;
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, "verified");
            preparedStatement.setInt(2, id); // corrected to setInt
            int stats = preparedStatement.executeUpdate(); // execute update statement

            if (stats > 0) {
                System.out.println("Verified GymOwner successfully");
            } else {
                throw new VerificationFailedException();
            }

            System.out.println("---------------------------------");

        } catch (VerificationFailedException ex) {
            System.out.println("Gym Owner " + ex.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            // Close resources to prevent memory leaks
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void verifyGyms(int id) {
        PreparedStatement preparedStatement = null;
        conn = JDBCConnection.getConnection();
        try {
            String query = SQLConstants.ADMIN_VERIFY_GYMS;
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, "verified"); // set input parameter 1
            preparedStatement.setInt(2, id); // corrected to setInt
            int stats = preparedStatement.executeUpdate(); // execute update statement
            if (stats > 0) {
                System.out.println("Verified Gym successfully");
            } else {
                throw new VerificationFailedException();
            }

            System.out.println("---------------------------------");

        } catch (VerificationFailedException ex) {
            System.out.println("Gym " + ex.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            // Close resources to prevent memory leaks
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Gym> getUnverifiedGyms() {
        conn = JDBCConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Gym> gyms = new ArrayList<>();

        try {
            String sqlQuery = SQLConstants.ADMIN_VIEW_UNVERIFIED_GYMS;
            preparedStatement = conn.prepareStatement(sqlQuery);
            preparedStatement.setString(1, "Unverified");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("gym_id");
                String gymAddress = resultSet.getString("gym_address");
                String gymName = resultSet.getString("gym_name");
                String gymOwnerID = resultSet.getString("owner_id");
                Gym gym = new Gym();
                gym.setGymId(id);
                gym.setGymName(gymName);
                gym.setGymAddress(gymAddress);
                gym.setOwnerId(gymOwnerID);
                gyms.add(gym);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            // Close resources to prevent memory leaks
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return gyms;
    }

    @Override
    public List<GymOwner> getUnverifiedGymOwner() {
        Connection conn = JDBCConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<GymOwner> gymOwners = new ArrayList<>();

        try {
            String sqlQuery = "SELECT owner_id, name, email, phone_number, aadhar, gst FROM GymOwners WHERE status = ?";
            preparedStatement = conn.prepareStatement(sqlQuery);
            preparedStatement.setString(1, "Unverified");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("owner_id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String ph = resultSet.getString("phone_number");
                String nationalId = resultSet.getString("aadhar");
                String gst = resultSet.getString("gst");

                GymOwner x = new GymOwner();
                x.setOwnerId(id);
                x.setOwnerName(name);
                x.setOwnerEmail(email);
                x.setPhoneNo(ph);
                x.setNationalId(nationalId);
                x.setGST(gst);

                gymOwners.add(x);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            // Close resources to prevent memory leaks
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return gymOwners;
    }
}
