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
                int id = rs.getInt(1);
                String topicName = rs.getString(2);
                int userId = rs.getInt(3);
                Timestamp createdAt = rs.getTimestamp(4);

                Topic t = new Topic(id,topicName,userId,createdAt);
                topicList.add(t);
            }
            return topicList;
        }
    }
}
