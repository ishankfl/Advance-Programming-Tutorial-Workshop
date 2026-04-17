package com.learninglog.learninglogproject.topic.controller;

import com.learninglog.learninglogproject.topic.model.Topic;
import com.learninglog.learninglogproject.topic.model.dao.TopicDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/edit-topic")
public class TopicEditServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id =  Integer.parseInt(req.getParameter("id"));
        String  name = req.getParameter("topic-name");
        try{
            TopicDao dao = new TopicDao();
            boolean result = dao.updateTopic(id, name);
            if(result){
                resp.sendRedirect("/topic?page=list");
                return;
            }
            else {
                req.setAttribute("error","Unable to update topic with this id");

            }
        }catch (Exception e){
            req.setAttribute("error","Something went wrong "+e.getMessage());
        }
        req.getRequestDispatcher("pages/edit-topic.jsp").forward(req,resp);
    }
}
