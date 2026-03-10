package com.learninglog.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static String URL = "jdbc:mysql://localhost:3306/learninglogs";
    private static String USER = "root";
    private static String PASSWORD = "1234";

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        return  conn;
    }
}

//DbConnection conn = new DbConnection();
//conn.get
