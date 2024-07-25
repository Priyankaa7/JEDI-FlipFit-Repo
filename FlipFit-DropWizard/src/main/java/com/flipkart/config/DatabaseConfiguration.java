package com.flipkart.config;

public class DatabaseConfiguration {
    private static final String URL = "jdbc:mysql://localhost:3306/flipfitapplication";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root@123";

    public static String getUrl() {
        return URL;
    }

    public static String getUsername() {
        return USERNAME;
    }

    public static String getPassword() {
        return PASSWORD;
    }
}
