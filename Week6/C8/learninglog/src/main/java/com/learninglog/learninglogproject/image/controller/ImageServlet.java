package com.learninglog.learninglogproject.image.controller;

import com.learninglog.learninglogproject.image.model.Image;
import com.learninglog.learninglogproject.image.model.dao.ImageDao;
import com.learninglog.learninglogproject.utils.ImageUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;

@WebServlet("/add-image")
@MultipartConfig
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("pages/image-upload.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        Part imagePart = req.getPart("image");
        try{
            String  filePath = ImageUtils.writeImage(imagePart);
            boolean result = ImageDao.insertImageDetails(name,filePath);
            if(result){
                req.setAttribute("success","Image added done");
            }
            else {
                req.setAttribute("error", "Unable to upload image");
            }
        }catch (Exception e){
            req.setAttribute("error", e.getMessage());

        }
        req.getRequestDispatcher("pages/image-upload.jsp").forward(req,resp);


    }
}
