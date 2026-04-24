package com.learninglog.learninglogproject.image.model.dao;

public class ImageDao {
    public static boolean insertImageDetails(
            String  name, String imagePath
    ){
        String query = "INSERT INTO images(name, path) VALUE (?,?)";
        return false;
    }
}
