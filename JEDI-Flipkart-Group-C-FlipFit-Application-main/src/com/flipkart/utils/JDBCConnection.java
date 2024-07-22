package com.flipkart.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnection {
    // A single instance of Connection to ensure singleton pattern
    private static Connection connection = null;
    // Method to get the database connection
    public static Connection getConnection() {
        try {
            // Check if the connection is valid and return it if so
            if (isValid()) {
                return connection;
            } else {
                try {
                    // Load properties from the configuration file
                    Properties prop = new Properties();
                    InputStream inputStream = JDBCConnection.class.getClassLoader().getResourceAsStream("./config.properties");
                    prop.load(inputStream);

                    // Get database connection properties
                    String driver = prop.getProperty("driver");
                    String url = prop.getProperty("url");
                    String user = prop.getProperty("user");
                    String password = prop.getProperty("password");
                    
                    // Load the database driver class
                    Class.forName(driver);
                    // Establish the database connection
                    connection = DriverManager.getConnection(url, user, password);
                    System.out.println("Connected to database");
                } catch (ClassNotFoundException e) {
                    // Handle case where the driver class is not found
                    e.printStackTrace();
                } catch (SQLException e) {
                    // Handle SQL related exceptions
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    // Handle case where the properties file is not found
                    e.printStackTrace();
                } catch (IOException e) {
                    // Handle I/O exceptions
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            // Handle SQL related exceptions
            e.printStackTrace();
            System.out.println("Connection failed");
        }
        return connection;
    }
    // Method to check if the connection is valid
    public static boolean isValid() throws SQLException {
        return connection != null && !connection.isClosed();
    }
}
