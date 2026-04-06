package com.learninglog.learninglogproject.topic.model.dao;

import com.learninglog.learninglogproject.topic.model.Topic;
import com.learninglog.learninglogproject.utils.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TopicDao {
    public boolean insertTopic
            (String name, int userId, Timestamp createdAt)
    throws SQLException {
        String query=
                "INSERT INTO topic (name, user_id, createdat) VALUES (?,?,?)";
        try(Connection conn = DbConnection.getConnection();
            PreparedStatement st = conn.prepareStatement(query)
        ){
            st.setString(1, name);
            st.setInt(2, userId);
            st.setTimestamp(3, createdAt);
            int rowsInserted = st.executeUpdate();
            if(rowsInserted<=0){return false;}
            else {return  true;}
        }
    }
    public static List<Topic> fetchTopics() throws SQLException{
        String query="SELECT * FROM topic";
        try(Connection conn = DbConnection.getConnection();
        PreparedStatement st = conn.prepareStatement(query)){
            ResultSet rs = st.executeQuery();

            List<Topic> topicList = new ArrayList<>();

            while (rs.next()){

                int id = rs.getInt(1);
                String name = rs.getString(2);
                int userId = rs.getInt(3);
                Timestamp createdDate = rs.getTimestamp(4);

                Topic t = new Topic(createdDate,userId,name,id);
                topicList.add(t);
            }
            return topicList;
        }
    }
}
