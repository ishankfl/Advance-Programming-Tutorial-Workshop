package com.learninglog.learninglogproject.topic.controller;

import com.learninglog.learninglogproject.topic.model.Topic;
import com.learninglog.learninglogproject.topic.model.dao.TopicDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet("/topic")
public class TopicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String page = req.getParameter("page"); // ?page=list

        if("list".equals(page)){
            //fetch data from topicDao
            try {
                List<Topic> topicList = TopicDao.fetchTopics();
                req.setAttribute("topics", topicList);

            }catch (Exception e){
                req.setAttribute("error","Unable to fetch topics"+e.getMessage());
            }

            // then send data to topic-list.jsp
            req.getRequestDispatcher("pages/topic-list.jsp")
                    .forward(req,resp);
        }
        if("edit".equals(page)){
            int id = Integer.parseInt(req.getParameter("id"));
            try{
                TopicDao dao = new TopicDao();
                Topic obj = dao.fetchTopicById(id);
                if(obj != null){
                    req.setAttribute("topic", obj);
//                    req.getRequestDispatcher("pages/edit-topic.jsp").forward(req,resp);
                }
                else{
                    req.setAttribute("error","Invalid Topic Id");
                }
            }catch (Exception e){
                req.setAttribute("error", "Something went wrong"+e.getMessage());
            }
            req.getRequestDispatcher("pages/edit-topic.jsp").forward(req,resp);
        }

        req.getRequestDispatcher("pages/add-topic.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String action = req.getParameter("action");
        if("add".equals(action)){
            String topicName = req.getParameter("topic-name");
            int userId = Integer.parseInt(req.getParameter("user-id"));
            System.out.println(req.getParameter("user-id"));
            Timestamp createdDate = new Timestamp(System.currentTimeMillis());
            try{
                TopicDao dao= new TopicDao();
                boolean result = dao.insertTopic(topicName,userId,createdDate);
                if(result){
                    //success
                }
                else{
                    //failed
                }
            }catch (Exception e){
                // failed
            }

        } else if ("edit".equals(action)) {
            int id =Integer.parseInt(req.getParameter("id"));
            String  updatedName = req.getParameter("topic-name");


        }
    }
}
