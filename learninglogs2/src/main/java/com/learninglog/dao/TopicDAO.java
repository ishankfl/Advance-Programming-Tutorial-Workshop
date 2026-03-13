package com.learninglog.dao;

import com.learninglog.model.Topic;
import com.learninglog.utils.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object (DAO) class for Topic.
 * This class handles all database operations related to the Topic table.
 */
public class TopicDAO {

    /**
     * Inserts a new topic into the database.
     *
     * @param name        Name of the topic
     * @param createdDate Timestamp when the topic was created
     * @param updatedDate Timestamp when the topic was last updated
     * @return Topic object with generated ID if insert successful, otherwise null
     * @throws SQLException if database error occurs
     */
    public Topic insertTopic(String name, Timestamp createdDate, Timestamp updatedDate) throws SQLException {

        // SQL query to insert topic data
        String query = "INSERT INTO topic (name, createdDate, updatedDate) VALUES (?, ?, ?)";

        // Try-with-resources automatically closes connection and statement
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            // Setting values to the prepared statement
            st.setString(1, name);
            st.setTimestamp(2, createdDate);
            st.setTimestamp(3, updatedDate);

            // Execute the insert query
            int rows = st.executeUpdate();

            // If rows inserted successfully
            if (rows > 0) {

                // Retrieve the auto-generated ID from the database
                ResultSet rs = st.getGeneratedKeys();

                if (rs.next()) {
                    int id = rs.getInt(1);

                    // Create and return Topic object
                    return new Topic(id, name, createdDate, updatedDate);
                }
            }
        }

        // Return null if insertion fails
        return null;
    }

    /**
     * Retrieves all topics from the database.
     *
     * @return List of Topic objects
     * @throws SQLException if database error occurs
     */
    public List<Topic> selectTopics() throws SQLException {

        // SQL query to fetch all topics
        String query = "SELECT * FROM topic";

        // List to store topic objects
        List<Topic> topicList = new ArrayList<>();

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            // Execute query
            ResultSet rs = preparedStatement.executeQuery();

            // Loop through result set
            while (rs.next()) {

                // Fetch column values
                int id = rs.getInt(1);
                String name = rs.getString(2);
                Timestamp createdDate = rs.getTimestamp(3);
                Timestamp updatedDate = rs.getTimestamp(4);

                // Create Topic object
                Topic topicObj = new Topic(id, name, createdDate, updatedDate);

                // Add Topic object to list
                topicList.add(topicObj);
            }
        }

        // Return list of topics
        return topicList;
    }
}