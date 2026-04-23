package com.learninglog.learninglogproject.image.controller;

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

@WebServlet("/image")
@MultipartConfig
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        super.doGet(req, resp);
        req.getRequestDispatcher("pages/image-upload.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        Part imagePart = req.getPart("image");

        String imagePath = ImageUtils.saveImage(imagePart, req);
        if(imagePath==null){
            req.setAttribute("error", "Something went wrong");
        }else{
            // send image path to the database
            try{
                boolean result = ImageDao.insertImage(name, imagePath);
                if(result){
                    req.setAttribute("success","Image uploaded successfully");
                }
                else {
                    req.setAttribute("error", "Image uploaded in directory but not in database");
                }
            }catch (Exception e){
                req.setAttribute("error", "Image uploaded in directory but not in db"+e.getMessage());
            }

        }
        req.getRequestDispatcher("pages/image-upload.jsp").forward(req,resp);
    }
}
