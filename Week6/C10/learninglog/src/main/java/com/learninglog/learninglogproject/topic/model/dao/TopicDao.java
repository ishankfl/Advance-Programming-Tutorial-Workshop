package com.learninglog.learninglogproject.topic.model.dao;

import com.learninglog.learninglogproject.topic.model.Topic;
import com.learninglog.learninglogproject.utils.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TopicDao {
    public boolean insertTopic(Topic obj)
            throws SQLException {
        String query =
                "INSERT INTO topic(name, user_id, createdat, updatedat)"
                        + "?, ?, ?, ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(query)
        ) {
            st.setString(1, obj.getName());
            st.setInt(2, obj.getUserId());
            st.setTimestamp(3, obj.getCreatedAt());
            st.setTimestamp(4, obj.getUpdatedAt());

            int rowsInserted = st.executeUpdate();
            if (rowsInserted == 0) {
                return false;
            } else {
                return true;
            }
        }
    }

    public List<Topic> fetchTopics() throws SQLException {
        String query = "SELECT * FROM topic";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(query)
        ) {
            ResultSet rs = st.executeQuery();
            List<Topic> allTopicsList = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int userId = rs.getInt("user_id");
                Timestamp createdAt = rs.getTimestamp("createdat");
                Timestamp updatedDate = rs.getTimestamp("updatedat");

                Topic obj = new Topic(id, name, userId, createdAt, updatedDate);

                allTopicsList.add(obj);
            }
            return allTopicsList;
        }

    }

    public static Topic fetchTopicById(int id) throws SQLException {
        String query = "SELECT * FROM topic WHERE id = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(query)
        ) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                Timestamp createdAt = rs.getTimestamp("createdat");
                Timestamp updatedAt = rs.getTimestamp("updatedat");
                int userId = rs.getInt("user_id");

                Topic obj = new Topic(id, name, userId, createdAt, updatedAt);
                return obj;
            }
            return null;

        }
    }

    public static boolean updateTopic(int id, String name) throws SQLException{
        String query = "UPDATE topic SET name = ? WHERE id = ?";
        try(Connection conn = DbConnection.getConnection();
            PreparedStatement st = conn.prepareStatement(query)
        ){
            st.setString(1, name);
            st.setInt(2, id);
            int rows = st.executeUpdate();
            if(rows>0){
                return true;
            }
            else{
                return false;
            }
        }
    }
}