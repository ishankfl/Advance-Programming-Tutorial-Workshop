package com.learninglog.model.dao;

import com.learninglog.model.Topic;
import com.learninglog.utils.DbConnection;

import java.sql.*;

public class TopicDAO {
    public Topic insertTopic(String name, Timestamp createdDate, Timestamp updatedDate) throws SQLException {
        String query = "INSERT INTO topic (name, createdDate, updatedDate) VALUES (?, ?, ?)";
        Connection conn = DbConnection.getConnection();
        PreparedStatement st = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        st.setString(1, name);
        st.setTimestamp(2, createdDate);
        st.setTimestamp(3, updatedDate);
        int rows = st.executeUpdate();

        if(rows>0){
            ResultSet rs = st.getGeneratedKeys();
            while (rs.next()){
                int id = rs.getInt(1);
                Topic topic = new Topic(id, name, createdDate, updatedDate);
                return topic;
            }
        }
        return  null;
    }
}
