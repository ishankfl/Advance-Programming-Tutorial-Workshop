package com.learninglog.learninglogproject.utils;

import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

public class ImageUtils {
    public static String writeImage(Part imagePart) throws IOException {
        String uploadDir = "H:\\TutorialWorksho\\Week6\\C8\\learninglog\\src\\main\\webapp\\images";
        File imagesPath = new File(uploadDir);
        if(!imagesPath.exists()){
            imagesPath.mkdirs();
        }
        String fileName = imagePart.getSubmittedFileName(); // ishan.png
        imagePart.write(uploadDir + File.separator + fileName);
        return "images/"+fileName;
    }
}
