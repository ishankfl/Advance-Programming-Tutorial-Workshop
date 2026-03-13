package com.learninglog.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class used to create a connection with the database.
 *
 * This class provides a static method that returns a database connection.
 * It is used by DAO classes whenever they need to interact with the database.
 */
public class DbConnection {

    // Database URL (database name: learninglogs)
    private static String URL = "jdbc:mysql://localhost:3306/learninglogs";

    // Database username
    private static String USER = "root";

    // Database password
    private static String PASSWORD = "1234";


    /**
     * Creates and returns a database connection.
     *
     * @return Connection object used to interact with the database
     * @throws SQLException if database connection fails
     */
    public static Connection getConnection() throws SQLException {

        // DriverManager establishes connection using URL, USER and PASSWORD
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

        // Return the connection object
        return conn;
    }
}