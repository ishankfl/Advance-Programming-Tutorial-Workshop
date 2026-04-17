package com.learninglog.learninglogproject.topic.controller;

import com.learninglog.learninglogproject.topic.model.dao.TopicDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/delete-topic")
public class TopicDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        try{

            boolean result = TopicDao.deleteTopic(id);
            if(result){
                resp.sendRedirect("/topic?page=list");
                return;
            }
            else {
                resp.sendRedirect("/topic?page=list");
            }
        }catch (Exception e){
            resp.sendRedirect("/topic?page=list");

        }
    }
}
