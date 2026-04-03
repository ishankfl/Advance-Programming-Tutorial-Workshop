package com.learninglog.learninglogproject.user.model.dao;

import com.learninglog.learninglogproject.user.model.User;

import java.sql.SQLException;

public interface UserDaoInterface {
    public boolean insertUser(String name, String email, String password) throws SQLException;
    public User loginUser(String email, String password)
            throws SQLException;
}
