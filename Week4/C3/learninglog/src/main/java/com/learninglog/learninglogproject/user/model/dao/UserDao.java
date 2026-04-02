package com.learninglog.learninglogproject.user.model.dao;

import com.learninglog.learninglogproject.user.model.User;
import com.learninglog.learninglogproject.utils.DbConnection;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// DAO class responsible for database operations related to User
public class UserDao implements UserDaoInterface {

    // Method to insert a new user into database
    @Override
    public boolean insertUser(User user) throws SQLException, IOException {

        // SQL query with placeholders (PreparedStatement prevents SQL Injection)
        String query = "INSERT INTO user (name, email, password) VALUES(?,?,?)";

        // Try-with-resources (automatically closes connection and statement)
        try (
                // Get database connection
                Connection conn = DbConnection.getConnection();

                // Prepare SQL statement
                PreparedStatement preparedStatement = conn.prepareStatement(query)
        ){

            // Get values from User object
            String name = user.getName();
            String email = user.getEmail();
            String password = user.getPassword();

            // Set values into query
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);

            // Execute insert query
            int insertedRow = preparedStatement.executeUpdate(); // insertedRow = 1

            // Check if row is inserted successfully
            if(insertedRow > 0)
            {
                return true;   // success
            }
            else {
                return false;  // failure
            }
        }

        }

        public User loginUser(String email, String  password)
        throws  SQLException{

            String query = "SELECT * FROM user WHERE email = ?";
            try(Connection conn = DbConnection.getConnection();
                PreparedStatement st = conn.prepareStatement(query)
            ){
                st.setString(1, email);
                ResultSet rs = st.executeQuery();
                if(rs.next()){
                   String storedHashedPassword = rs.getString("password");
                   if(BCrypt.checkpw(password,storedHashedPassword)){
                       int id = rs.getInt("id");
                       String name = rs.getString("name");
                       User userObj = new User(id, name, email, storedHashedPassword);
                       return  userObj;

                   }
                }
                return null;
            }
        }

    @Override
    public List<User> userList() throws  SQLException{
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM user";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(query);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");

                User user = new User(id, name, email, password);
                users.add(user);
            }

        }
        return users;
    }

}