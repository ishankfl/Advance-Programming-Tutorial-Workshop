package com.learninglog.learninglogproject.topic.model.dao;

import com.learninglog.learninglogproject.topic.model.Topic;
import com.learninglog.learninglogproject.utils.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TopicDao {
    public boolean insertTopic (String name, int userId, Timestamp createdAt)throws SQLException {
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

                int id = rs.getInt("id");
                String name = rs.getString("name");
                int userId = rs.getInt("user_id");
                Timestamp createdDate = rs.getTimestamp("createdat");

                Topic t = new Topic(createdDate,userId,name,id);
                topicList.add(t);
            }
            return topicList;
        }
    }
    public static  Topic fetchTopicById(int id) throws  SQLException{
        String query = "SELECT * FROM topic WHERE id = ?";
        try(Connection conn = DbConnection.getConnection();
            PreparedStatement st = conn.prepareStatement(query)
        ){
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                String  name = rs.getString("name");
                int userId = rs.getInt("user_id");
                Timestamp createdDate = rs.getTimestamp("createdat");
                Topic obj = new Topic(createdDate , userId,name,id);
                return obj;
            }
            return null;
        }
    }

    public static  boolean updateTopic(int id , String name)
        throws SQLException{
        String  query="UPDATE topic SET name = ? WHERE id = ?";
        try(Connection conn = DbConnection.getConnection();
        PreparedStatement st = conn.prepareStatement(query)){
            st.setString(1, name);
            st.setInt(2, id);

            int updatedRows = st.executeUpdate();
            if(updatedRows>0){
                return true;
            }
            else {
                return false;
            }
        }
    }

}
