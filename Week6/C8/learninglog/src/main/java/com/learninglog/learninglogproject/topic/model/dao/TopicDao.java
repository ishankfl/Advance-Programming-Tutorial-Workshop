package com.learninglog.learninglogproject.topic.model.dao;

import com.learninglog.learninglogproject.topic.model.Topic;
import com.learninglog.learninglogproject.utils.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TopicDao {
    public boolean insertTopic(
            String name, int userId, Timestamp createdDate
    )throws SQLException {
        String query="INSERT INTO topic(name, user_id, createdat)"+
                "VALUES (?,?,?)";
        try(Connection conn = DbConnection.getConnection();
            PreparedStatement st = conn.prepareStatement(query)){
            st.setString(1, name);
            st.setInt(2, userId);
            st.setTimestamp(3, createdDate);
            int insertedRows = st.executeUpdate();
            if(insertedRows > 0){return  true;}
            else {return  false;}
        }
    }
    public static List<Topic> fetchTopics() throws SQLException{
        String query="SELECT * FROM topic";
        try(Connection conn = DbConnection.getConnection();
            PreparedStatement st = conn.prepareStatement(query)
        ){
           ResultSet rs =  st.executeQuery();
           List<Topic> topicList = new ArrayList<>();

           while (rs.next()){
               int id = rs.getInt(1);
               String  name = rs.getString(2);
               int userId = rs.getInt(3);
               Timestamp createdDate = rs.getTimestamp(4);
               Topic obj = new Topic(id,name,userId,createdDate);
               topicList.add(obj);
           }
           return topicList;
        }
    }
    public Topic fetchTopicById(int id) throws SQLException{
        String query = "SELECT * FROM topic WHERE id = ?";
        try(Connection conn = DbConnection.getConnection();
            PreparedStatement st = conn.prepareStatement(query)
        ){
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                String name = rs.getString("name");
                int userId = rs.getInt("user_id");
                Timestamp createdAt = rs.getTimestamp("createdat");
                Topic obj = new Topic(id,name,userId,createdAt);
                return obj;
            }
            return null;
        }
    }

    public boolean updateTopic(int id, String name)
            throws SQLException{
        String  query="UPDATE topic SET name = ? WHERE id = ?";
        try(Connection conn = DbConnection.getConnection();
            PreparedStatement st = conn.prepareStatement(query)
        ){
            st.setString(1, name);
            st.setInt(2, id);

            int updatedRows = st.executeUpdate();
            if(updatedRows > 0){
                return  true;
            }
            else {
                return false;
            }
        }
    }

    public static boolean deleteTopic(int id) throws SQLException{
        String  query= "DELETE FROM topic WHERE id = ?";
        try(Connection conn = DbConnection.getConnection();
        PreparedStatement st = conn.prepareStatement(query)){
            st.setInt(1, id);
            int rowsDeleted = st.executeUpdate();
            if(rowsDeleted>0)
            {
                return  true;
            }
            else {
                return false;
            }
        }
    }

}
