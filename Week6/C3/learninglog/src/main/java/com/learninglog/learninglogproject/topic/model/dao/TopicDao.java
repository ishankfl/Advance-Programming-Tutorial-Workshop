package com.learninglog.learninglogproject.topic.model.dao;

import com.learninglog.learninglogproject.topic.model.Topic;
import com.learninglog.learninglogproject.utils.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TopicDao {
    public static boolean insertTopic(Topic topic)
    throws SQLException {
        String name = topic.getname();
        int userId = topic.getUserId();
        Timestamp createdAt = topic.getCreatedAt();
        Timestamp updatedAt = topic.getUpdatedAt();

        String query = "INSERT INTO topic (name, user_id, createdat, updatedat)" +
                "VALUE(?,?,?,?)";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(query);
        ) {
            st.setString(1, name);
            st.setInt(2, userId);
            st.setTimestamp(3, createdAt);
            st.setTimestamp(4, updatedAt);
            int rowsInserted = st.executeUpdate();
            if (rowsInserted > 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static List<Topic> fetchTopics()
    throws SQLException{

        String  query="SELECT * FROM topic";
        try(Connection conn = DbConnection.getConnection();
            PreparedStatement st = conn.prepareStatement(query)
        ){
            ResultSet rs = st.executeQuery();

            List<Topic> topicList = new ArrayList<>();
            while (rs.next()){
                int id = rs.getInt(1);
                String  name = rs.getString(2);
                int userId = rs.getInt(3);
                Timestamp crDate = rs.getTimestamp(4);
                Timestamp upDate = rs.getTimestamp(5);

                Topic topicObj = new Topic(id,name, userId, crDate, upDate);
                topicList.add(topicObj);
            }
            return topicList;
        }
    }
}
