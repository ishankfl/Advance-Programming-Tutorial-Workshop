package com.learninglog.learninglogproject.image.model.dao;

import com.learninglog.learninglogproject.utils.DbConnection;

import java.awt.image.DataBuffer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImageDao {
    public static  boolean insertImage(String  name, String  imagePath)
        throws SQLException{
//        create table uploaded_image(
//                int id primary key auto_increment,
//                name varchar(20),
//                image_path varchar(100)
//        );
        String query = "INSERT INTO uploaded_image (name, image_path)" +
                "VALUES(?,?)";
        try(Connection conn = DbConnection.getConnection();
            PreparedStatement st = conn.prepareStatement(query)){
            st.setString(1, name);
            st.setString(2, imagePath);
            int rowsAdded = st.executeUpdate();
            if(rowsAdded>0){return true;}
            else{return false;}

        }

    }
}
