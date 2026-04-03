package com.learninglog.learninglogproject.topic.model.dao;

import com.learninglog.learninglogproject.topic.model.Topic;
import com.learninglog.learninglogproject.utils.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TopicDao {
    public static boolean insertTopic(Topic topicObj) throws SQLException {
        String query=
                "INSERT INTO topic(name, user_id, createdAt) VALUES(?, ?, ?)";
        try(Connection conn = DbConnection.getConnection();
            PreparedStatement st = conn.prepareStatement(query)
        ){
            st.setString(1, topicObj.getName());
            st.setInt(2, topicObj.getUser_id());
            st.setTimestamp(3, topicObj.getCreatedAt());

            int insertedRows = st.executeUpdate();
            if(insertedRows == 0){
                return  false;
            }else {
                return true;
            }
        }
    }
}
