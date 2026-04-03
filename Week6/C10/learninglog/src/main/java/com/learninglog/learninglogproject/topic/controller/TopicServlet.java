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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        req.getRequestDispatcher("pages/add-topic.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        String  action = req.getParameter("action");
        if(action.equals("add")){
            // add topic dao
            TopicDao dao = new TopicDao();
            int userId = Integer.parseInt(req.getParameter("user_id"));

            String topicName = req.getParameter("topic_name");
            Timestamp createdDate = new Timestamp(System.currentTimeMillis());
            Timestamp updatedDate = new Timestamp(System.currentTimeMillis());

            Topic obj = new Topic();
            obj.setName(topicName);
            obj.setUserId(userId);
            obj.setCreatedAt(createdDate);
            obj.setUpdatedAt(updatedDate);
            try {
                boolean result = dao.insertTopic(obj);
            }catch (Exception e){

            }
        }
    }
}
