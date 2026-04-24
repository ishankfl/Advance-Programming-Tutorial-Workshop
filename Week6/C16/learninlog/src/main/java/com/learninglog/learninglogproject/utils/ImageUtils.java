package com.learninglog.learninglogproject.utils;

import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

public class ImageUtils {
    public static  String saveImageInDirectory(Part imagePart)
    throws IOException {

        String location = "H:\\TutorialWorksho\\Week6\\C16\\learninlog\\src\\main\\webapp\\image";

        File imageUploadLocation = new File(location);
        if(!imageUploadLocation.exists()){
            imageUploadLocation.mkdirs();
        }
        String  fileName = imagePart.getSubmittedFileName();

        imagePart.write(location + File.separator + fileName);

        return "image/"+fileName;

    }
}
