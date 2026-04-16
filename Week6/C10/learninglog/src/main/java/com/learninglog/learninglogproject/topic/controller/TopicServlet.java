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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        String page = req.getParameter("page");

//        if(page.equals("list"))
        if("list".equals(page))
        {
            TopicDao dao = new TopicDao();
            try{
                List<Topic> topicList = dao.fetchTopics();
                req.setAttribute("topics", topicList);

            }catch (Exception e){
                req.setAttribute("error",e.getMessage());
            }
            req.getRequestDispatcher("pages/topic-list.jsp").forward(req,resp);
        }
        else if("edit".equals(page)){

            int id = Integer.parseInt(req.getParameter("id"));
            try{
                Topic topicObj = TopicDao.fetchTopicById(id);
                if(topicObj==null){
                    req.setAttribute("error", "Unable to fetch topic with this id"+id);
                }
                else{
                    req.setAttribute("success", "Successfully fetched the topic");
                    req.setAttribute("topic",topicObj);
                }
            }catch (Exception e){
                req.setAttribute("error","Something went wrong"+e.getMessage());

            }
            req.getRequestDispatcher("pages/edit-topic.jsp").forward(req,resp);
        }


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
                if(result){
                    req.setAttribute("sucess","Successfully topic added");
                }
                else{
                    req.setAttribute("error","Unable to add topic");
                }
            }catch (Exception e){
                req.setAttribute("error",e.getMessage());
            }
            req.getRequestDispatcher("pages/add-topic.jsp").forward(req,resp);
        }
    }
}
