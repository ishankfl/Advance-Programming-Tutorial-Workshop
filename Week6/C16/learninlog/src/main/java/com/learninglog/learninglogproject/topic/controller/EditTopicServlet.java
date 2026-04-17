package com.learninglog.learninglogproject.topic.controller;

import com.learninglog.learninglogproject.topic.model.dao.TopicDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/edit-topic")
public class EditTopicServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String  updatedName = req.getParameter("name");
        try{
            boolean result = TopicDao.updateTopic(id, updatedName);
            if(result){
                resp.sendRedirect("/topic?page=list");
                return;
            }
            else {
                req.setAttribute("error","Unable to update the topic");
            }
        }catch (Exception e){
            req.setAttribute("error","Something went wrong"+e.getMessage());
        }
        req.getRequestDispatcher("pages/edit-topic-form.jsp").forward(req,resp);
    }
}
