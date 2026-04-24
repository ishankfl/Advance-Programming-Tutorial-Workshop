package com.learninglog.learninglogproject.utils;

import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

public class ImageUtils {
    public static String writeImage(Part imagePart)
    throws IOException {
        String uploadDir = "H:\\TutorialWorksho\\Week6\\C11\\learninglog\\src\\main\\webapp\\images";
        String  fileName = imagePart.getSubmittedFileName();

        imagePart.write(uploadDir + File.separator + fileName);

        return "images/"+fileName;
    }
}
