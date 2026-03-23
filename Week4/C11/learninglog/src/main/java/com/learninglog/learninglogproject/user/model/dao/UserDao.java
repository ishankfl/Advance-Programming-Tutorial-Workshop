package com.learninglog.learninglogproject.user.model.dao;

import com.learninglog.learninglogproject.user.model.User;
import com.learninglog.learninglogproject.utils.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
    public boolean insertUser(User user) throws SQLException {
        String query="INSERT INTO user(name, email,password)" +
                "VALUE(?,?,?)";
        try(Connection conn = DbConnection.getConnection();
            PreparedStatement st = conn.prepareStatement(query)
        ){
            st.setString(1, user.getName());
            st.setString(2, user.getEmail());
            st.setString(3, user.getPassword());
            int rowsInserted = st.executeUpdate();
            if(rowsInserted > 0){
                return  true;
            }
            else {
                return false;
            }
        }
    }
}
