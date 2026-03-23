package com.learninglog.learninglogproject.user.model.dao;

import com.learninglog.learninglogproject.user.model.User;
import com.learninglog.learninglogproject.utils.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao implements  UserDaoInterface{
    public boolean insertUser(String fullName, String email, String passowrd) throws
            SQLException {
        String query = "INSERT INTO user (name, email, password) VALUE (?,?,?)";
        try(Connection conn = DbConnection.getConnection();
            PreparedStatement st= conn.prepareStatement(query)
        ){
            st.setString(1, fullName);
            st.setString(2, email);
            st.setString(3, passowrd);

            int insertedRows = st.executeUpdate();
            if (insertedRows > 0){
                return  true; // this will execute after successfully data inserted

            }else{
                return  false; // this will excute if failed to insert data

            }
        }
//        return  false;

    }

}
