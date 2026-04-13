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
import java.util.List;

@WebServlet("/topic")
public class TopicServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("page");

        if("list".equals(action)){
            try{
                List<Topic> topicList = TopicDao.fetchTopics();
                req.setAttribute("topics", topicList);

            }
            catch (Exception e){
                req.setAttribute("error","Unable to fetch the topics "+e.getMessage());
            }
            req.getRequestDispatcher("pages/topic-list.jsp").forward(req,resp);
        }

        if("edit".equals(action)){

            try{
                int id = Integer.parseInt(req.getParameter("id"));
                Topic topicData=TopicDao.fetchTopicById(id);
                req.setAttribute("topicData", topicData);

            }catch (Exception e){
                req.setAttribute("error", "Something wend wrong"+e.getMessage());
            }
            req.getRequestDispatcher("pages/edit-topic-form.jsp").forward(req,resp);
        }


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
