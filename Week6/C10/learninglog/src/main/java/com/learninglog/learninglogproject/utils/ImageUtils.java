package com.learninglog.learninglogproject.utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

import java.io.File;

public class ImageUtils {
    public static  String saveImage(Part imagePart, HttpServletRequest req){
        try {
            String directory = "H:\\TutorialWorksho\\Week6\\C10\\learninglog\\src\\main\\webapp\\images";

            File uploadPath = new File(directory);
            if (!uploadPath.exists()) {
                uploadPath.mkdirs();
            }
            String fileName = imagePart.getSubmittedFileName();
            String fullPath = directory + File.separator + fileName;

            imagePart.write(fullPath);

            return "images/"+fileName;

        }catch (Exception e){

            return null;
        }


    }
}
