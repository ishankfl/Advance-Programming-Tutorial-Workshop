package com.learninglog.learninglogproject.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    static String URL = "jdbc:mysql://localhost:3306/learninglogs";
    static String USER = "root";
    static String PASSWORD = "1234";

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // <-- MySQL Connector/J driver class
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}