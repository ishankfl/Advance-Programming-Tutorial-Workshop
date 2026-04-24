package com.learninglog.learninglogproject.image.model.dao;

import com.oracle.wls.shaded.org.apache.regexp.RE;

public class ImageDao {
    public static boolean insertImageDetails(
            String  name, String imagePath
    ){
        String query = "INSERT INTO images(name, path)" +
                "VALUES (?,?)";
        //---complete this function
        return  true;
    }
}
