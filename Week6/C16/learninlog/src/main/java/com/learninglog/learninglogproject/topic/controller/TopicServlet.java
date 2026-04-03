package com.learninglog.learninglogproject.topic.controller;

import com.learninglog.learninglogproject.topic.model.Topic;
import com.learninglog.learninglogproject.topic.model.dao.TopicDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;

@WebServlet("/topic")
public class TopicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("pages/add-topic.jsp")
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String action= req.getParameter("action");
    if(action.equals("add")){
        int userId = Integer.parseInt(req.getParameter("user-id"));
        String topicName = req.getParameter("topic-name");
        Timestamp createdDate = new Timestamp(System.currentTimeMillis());

        Topic topicObj = new Topic();
        topicObj.setUser_id(userId);
        topicObj.setName(topicName);
        topicObj.setCreatedAt(createdDate);

        try{
            boolean result = TopicDao.insertTopic(topicObj);
            if(result==true){
                resp.sendRedirect("/view-topics");
            }
            else{
                // send error message to the page
            }
        }catch (Exception e){
            ///  send error message to add-topic-form
        }






    }
    }
}
