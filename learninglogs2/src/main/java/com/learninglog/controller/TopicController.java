package com.learninglog.controller;

import com.learninglog.model.Topic;
import com.learninglog.dao.TopicDAO;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller class for Topic.
 *
 * This class acts as a middle layer between the View (UI/Servlet/JSP)
 * and the Data Access Layer (TopicDAO).
 *
 * It handles business logic related to Topics.
 */
public class TopicController {

    // Temporary list to store topics in memory (not used for DB operations)
    private List<Topic> topics = new ArrayList<>();

    // Counter for topic IDs if working with in-memory data
    private int topicIdCounter = 1;

    // DAO object to perform database operations
    TopicDAO topicDAO = new TopicDAO();


    /**
     * Adds a new topic to the database.
     *
     * @param name Name of the topic
     * @return Topic object that was inserted into the database
     * @throws SQLException if database error occurs
     */
    public Topic addTopic(String name) throws SQLException {

        // Create current timestamp for created date
        Timestamp createdDate = new Timestamp(System.currentTimeMillis());

        // Create current timestamp for updated date
        Timestamp updatedDate = new Timestamp(System.currentTimeMillis());

        // Call DAO method to insert topic into database
        Topic topic = topicDAO.insertTopic(name, createdDate, updatedDate);

        // Return the inserted topic object
        return topic;
    }


    /**
     * Fetches all topics from the database.
     *
     * @return List of Topic objects
     * @throws SQLException if database error occurs
     */
    public List<Topic> fetchAllTopics() throws SQLException {

        // Call DAO method to retrieve topics from database
        List<Topic> topicList = topicDAO.selectTopics();

        // Return the list of topics
        return topicList;
    }


    /**
     * Retrieves a topic from the in-memory list using its ID.
     * (This method does NOT fetch from the database)
     *
     * @param id Topic ID
     * @return Topic object if found, otherwise null
     */
    public Topic getTopicById(int id) {

        // Loop through the in-memory topic list
        for (Topic t : topics) {

            // Check if topic ID matches
            if (t.getId() == id)
                return t;
        }

        // Return null if topic not found
        return null;
    }
}