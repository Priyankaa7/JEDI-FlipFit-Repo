package com.flipkart.dao;

import com.flipkart.bean.GymOwner;
import com.flipkart.constants.SQLConstants;
import com.flipkart.exception.InvalidCredentialsException;
import com.flipkart.exception.RegistrationFailedException;
import com.flipkart.utils.JDBCConnection;

import java.sql.*;

public class GymOwnerDAOImplementation implements GymOwnerDAOInterface {

    private Connection conn;

    @Override
    public void newGymOwner(GymOwner gymOwner) {
        conn = JDBCConnection.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            String insertQuery = SQLConstants.GYM_OWNER_INSERT;
            preparedStatement = conn.prepareStatement(insertQuery);

            preparedStatement.setString(1, gymOwner.getOwnerEmail());
            preparedStatement.setString(2, gymOwner.getOwnerName());
            preparedStatement.setString(3, gymOwner.getPassword());
            preparedStatement.setString(4, gymOwner.getPhoneNo());
            preparedStatement.setString(5, gymOwner.getPAN());
            preparedStatement.setString(6, gymOwner.getNationalId());
            preparedStatement.setString(7, gymOwner.getGST());
            preparedStatement.setString(8, gymOwner.getStatus());

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Record inserted successfully!");
            } else {
                throw new RegistrationFailedException();
            }

        } catch (RegistrationFailedException ex) {
            System.out.println("Gym Owner" + ex.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean verifyGymOwnerPassword(String email, String password) {
        conn = JDBCConnection.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            statement = conn.createStatement();
            preparedStatement = conn.prepareStatement(SQLConstants.GYM_OWNER_VERIFY_PASSWORD, statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                if (result.getString("status").equals("Unverified")) {
                    System.out.println("Unverified User, please contact admin to verify");
                    return false;
                }
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean sendProfileForApproval(String ownerId) {
        conn = JDBCConnection.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            statement = conn.createStatement();
            String query = "UPDATE GymOwners SET status = 'Pending' WHERE owner_id = ?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, ownerId);
            int rowsUpdated = preparedStatement.executeUpdate();

            return rowsUpdated > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public void updateGymOwnerPassword(String email, String password, String updatedPassword) {
        conn = JDBCConnection.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            statement = conn.createStatement();
            preparedStatement = conn.prepareStatement(SQLConstants.GYM_OWNER_UPDATE_PASSWORD, statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, updatedPassword);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Updated Password successfully!");
            } else {
                throw new InvalidCredentialsException();
            }

        } catch (InvalidCredentialsException ex) {
            System.out.println("Gym Owner" + ex.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getOwnerIdByEmail(String email) {
        conn = JDBCConnection.getConnection();
        String ownerId = null;
        String query = "SELECT owner_id FROM GymOwners WHERE email = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    ownerId = resultSet.getString("owner_id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ownerId;
    }
}
