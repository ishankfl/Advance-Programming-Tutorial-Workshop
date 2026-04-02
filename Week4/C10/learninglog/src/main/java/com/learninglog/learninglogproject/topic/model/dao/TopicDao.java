package com.learninglog.learninglogproject.topic.model.dao;

import com.learninglog.learninglogproject.topic.model.Topic;
import com.learninglog.learninglogproject.utils.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TopicDao {
    public boolean insertTopic(Topic obj)
        throws SQLException
    {
        String query=
                "INSERT INTO topic(name, user_id, createdat, updatedat)"
                +"?, ?, ?, ?";
        try(Connection conn = DbConnection.getConnection();
            PreparedStatement st = conn.prepareStatement(query)
        ){
            st.setString(1, obj.getName());
            st.setInt(2, obj.getUserId());
            st.setTimestamp(3, obj.getCreatedAt());
            st.setTimestamp(4, obj.getUpdatedAt());

            int rowsInserted = st.executeUpdate();
            if(rowsInserted==0){
                return false;
            }else {
                return true;
            }


        }
    }
}
