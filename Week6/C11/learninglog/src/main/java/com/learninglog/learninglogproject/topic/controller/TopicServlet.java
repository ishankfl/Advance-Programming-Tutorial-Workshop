package com.learninglog.learninglogproject.topic.controller;

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
//        super.doGet(req, resp);
        req.getRequestDispatcher("pages/add-topic.jsp")
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if(action.equals("add")){
            int userId = Integer.parseInt(req.getParameter("user-id"));
            String  topicName = req.getParameter("topic-name");
            Timestamp createdAt = new Timestamp(System.currentTimeMillis());

            TopicDao dao = new TopicDao();
            try {
                boolean result = dao.insertTopic(topicName, userId, createdAt);

            }catch (Exception e){

            }

            // continue to add topic
        } else if (action.equals("edit")) {
         // continue to edit topic
        }
    }

}
