package com.learninglog.learninglogproject.user.model.dao;

import com.learninglog.learninglogproject.user.model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UserDaoInterface {
    public boolean insertUser(User user) throws SQLException, IOException;
//    public List<User>  fetchUser();
}
