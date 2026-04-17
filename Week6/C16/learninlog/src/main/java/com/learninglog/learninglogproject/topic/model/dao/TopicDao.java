package com.learninglog.learninglogproject.topic.model.dao;

import com.learninglog.learninglogproject.topic.model.Topic;
import com.learninglog.learninglogproject.utils.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public static List<Topic> fetchTopics() throws SQLException{
        String query = "SELECT * FROM topic";
        try(Connection conn = DbConnection.getConnection();
        PreparedStatement st  = conn.prepareStatement(query)){

            ResultSet rs = st.executeQuery();

            List<Topic> topicList = new ArrayList<>();

            while (rs.next()){
                int id = rs.getInt("id");
                String topicName = rs.getString("name");
                int userId = rs.getInt("user_id");
                Timestamp createdAt = rs.getTimestamp("createdat");

                Topic t = new Topic(id,topicName,userId,createdAt);
                topicList.add(t);
            }
            return topicList;
        }
    }
    public  static  Topic fetchTopicById(int id) throws SQLException{
        String query = "SELECT * FROM topic WHERE id = ?";
        try(Connection conn = DbConnection.getConnection();
        PreparedStatement st = conn.prepareStatement(query)){
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                String  topicName = rs.getString("name");
                int userId = rs.getInt("user_id");
                Timestamp createdDate = rs.getTimestamp("createdat");
                Topic topic = new Topic(id, topicName, userId, createdDate);
                return  topic;
            }
            return null;
        }
    }

    public  static boolean updateTopic(int id, String name)
        throws SQLException
    {
        String query = "UPDATE topic SET name = ? WHERE id = ?";
        try(Connection conn = DbConnection.getConnection();
        PreparedStatement st = conn.prepareStatement(query)){
            st.setString(1, name);
            st.setInt(2, id);

            int effectedRows = st.executeUpdate();
            if(effectedRows>0){
                return true;
            }else {
                return false;
            }
        }
    }
}
