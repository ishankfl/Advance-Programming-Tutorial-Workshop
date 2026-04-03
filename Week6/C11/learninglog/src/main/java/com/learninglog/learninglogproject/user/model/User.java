package com.learninglog.learninglogproject.user.model;

// User model class (POJO - Plain Old Java Object)
// This class is used to store user data
public class User {

    // Instance variables (fields)
    private int id;           // User ID (usually primary key in database)
    private String name;      // User full name
    private String email;     // User email address
    private String password;  // User password

    // Default constructor (required for frameworks / flexibility)
    public User(){}

    // Parameterized constructor (used to create object with values)
    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }
}