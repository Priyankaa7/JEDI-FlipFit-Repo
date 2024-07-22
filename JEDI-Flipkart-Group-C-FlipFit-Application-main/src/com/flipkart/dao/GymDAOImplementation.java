/*package com.flipkart.dao;

import com.flipkart.bean.Gym;
import com.flipkart.bean.Slots;
import com.flipkart.utils.JDBCConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GymDAOImplementation implements GymDAOInterface {

    private Connection conn;

    @Override
    public List<Gym> getGymsByOwnerId(String ownerId) {
        List<Gym> gymsList = new ArrayList<>();
        conn = JDBCConnection.getConnection();

        String query = "SELECT * FROM Gyms WHERE owner_id = ?";  // Make sure table name and column names are correct

        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, ownerId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Gym gym = new Gym();
                    gym.setGymId(resultSet.getInt("gym_id"));
                    gym.setGymName(resultSet.getString("gym_name"));
                    gym.setGymAddress(resultSet.getString("gym_address"));
                    gym.setOwnerId(resultSet.getString("owner_id"));

                    // Fetching slots for each gym
                    List<Slots> slotsList = getSlotsByGymId(gym.getGymId());
                    gym.setSlots(slotsList);

                    gymsList.add(gym);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return gymsList;
    }

    private List<Slots> getSlotsByGymId(int gymId) {
        List<Slots> slotsList = new ArrayList<>();
        String query = "SELECT * FROM Slots WHERE gym_id = ?";

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setInt(1, gymId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Slots slot = new Slots(resultSet.getInt("slots_id"), resultSet.getInt("start_time"), resultSet.getInt("seat_count"));
                    slotsList.add(slot);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return slotsList;
    }

    @Override
    public void addGym(Gym gym) {
        conn = JDBCConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String insertGymQuery = "INSERT INTO Gyms (gym_name, gym_address, owner_id) VALUES (?, ?, ?)";

        try {
            preparedStatement = conn.prepareStatement(insertGymQuery, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, gym.getGymName());
            preparedStatement.setString(2, gym.getGymAddress());
            preparedStatement.setString(3, gym.getOwnerId());

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Gym added successfully!");
                resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    int gymId = resultSet.getInt(1);
                    gym.setGymId(gymId);
                    insertSlots(gym.getSlots(), gymId);
                }
            } else {
                throw new SQLException("Failed to add the gym.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void insertSlots(List<Slots> slots, int gymId) {
        conn = JDBCConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String insertSlotQuery = "INSERT INTO Slots (start_time, seat_count, gym_id) VALUES (?, ?, ?)";

        try {
            preparedStatement = conn.prepareStatement(insertSlotQuery);

            for (Slots slot : slots) {
                preparedStatement.setInt(1, slot.getStartTime());
                preparedStatement.setInt(2, slot.getSeatCount());
                preparedStatement.setInt(3, gymId);
                preparedStatement.addBatch();
            }

            int[] rowsInserted = preparedStatement.executeBatch();

            if (rowsInserted.length > 0) {
                System.out.println("Slots added successfully!");
            } else {
                throw new SQLException("Failed to add slots.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
*/

package com.flipkart.dao;

import com.flipkart.bean.Gym;
import com.flipkart.bean.Slots;
import com.flipkart.utils.JDBCConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GymDAOImplementation implements GymDAOInterface {

    @Override
    public List<Gym> getGymsByOwnerId(String ownerId) {
        List<Gym> gymsList = new ArrayList<>();
        String query = "SELECT * FROM Gyms WHERE owner_id = ?";

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setString(1, ownerId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Gym gym = new Gym();
                    gym.setGymId(resultSet.getInt("gym_id"));
                    gym.setGymName(resultSet.getString("gym_name"));
                    gym.setGymAddress(resultSet.getString("gym_address"));
                    gym.setOwnerId(resultSet.getString("owner_id"));

                    // Fetching slots for each gym
                    List<Slots> slotsList = getSlotsByGymId(gym.getGymId(), conn);  // Pass connection to reuse it
                    gym.setSlots(slotsList);

                    gymsList.add(gym);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gymsList;
    }

    private List<Slots> getSlotsByGymId(int gymId, Connection conn) {
        List<Slots> slotsList = new ArrayList<>();
        String query = "SELECT * FROM Slots WHERE gym_id = ?";

        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setInt(1, gymId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int slotsId = resultSet.getInt("slots_id");
                    String timeSlot = resultSet.getString("start_time");  // Changed to String
                    int seatCount = resultSet.getInt("seat_count");
                    Slots slot = new Slots(slotsId, timeSlot, seatCount);  // Convert Time to String
                    slotsList.add(slot);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return slotsList;
    }

    @Override
    public void addGym(Gym gym) {
        String insertGymQuery = "INSERT INTO Gyms (gym_name, gym_address, owner_id) VALUES (?, ?, ?)";

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(insertGymQuery, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, gym.getGymName());
            preparedStatement.setString(2, gym.getGymAddress());
            preparedStatement.setString(3, gym.getOwnerId());

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Gym added successfully!");
                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        int gymId = resultSet.getInt(1);
                        gym.setGymId(gymId);
                        insertSlots(gym.getSlots(), gymId);
                    }
                }
            } else {
                throw new SQLException("Failed to add the gym.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertSlots(List<Slots> slots, int gymId) {
        String insertSlotQuery = "INSERT INTO Slots (start_time, seat_count, gym_id) VALUES (?, ?, ?)";

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(insertSlotQuery)) {

            for (Slots slot : slots) {
                preparedStatement.setString(1, slot.getTimeSlot());  // Use String for time slot
                preparedStatement.setInt(2, slot.getSeatCount());
                preparedStatement.setInt(3, gymId);
                preparedStatement.addBatch();
            }

            int[] rowsInserted = preparedStatement.executeBatch();

            if (rowsInserted.length > 0) {
                System.out.println("Slots added successfully!");
            } else {
                throw new SQLException("Failed to add slots.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
