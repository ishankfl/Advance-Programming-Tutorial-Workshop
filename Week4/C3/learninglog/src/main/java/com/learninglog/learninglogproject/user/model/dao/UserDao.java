package com.learninglog.learninglogproject.user.model.dao;

import com.learninglog.learninglogproject.user.model.User;
import com.learninglog.learninglogproject.utils.DbConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDao implements UserDaoInterface{
    @Override
    public boolean insertUser(User user) throws SQLException, IOException {
        String query = "INSERT INTO user (name, email, password) VALUES(?,?,?)";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)
        ){
            String name = user.getName();
            String email = user.getEmail();
            String  password = user.getPassword();

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);

            int insertedRow = preparedStatement.executeUpdate();
            if(insertedRow > 0)
            {
                return  true;
            }
            else {
                return false;
            }
        }
    }
//    public List<User> fetchUser(){
//
//    }
}
