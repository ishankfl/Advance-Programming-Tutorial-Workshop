package com.learninglog.learninglogproject.user.controller;

import com.learninglog.learninglogproject.user.model.User;
import com.learninglog.learninglogproject.user.model.dao.UserDao;
import com.learninglog.learninglogproject.user.model.dao.UserDaoInterface;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("pages/login.jsp").forward(req, resp);
    }

    @Override
    protected  void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException,
            IOException
            {
        String email = req.getParameter("email");
        String  password = req.getParameter("password");
        try{
            UserDaoInterface userDao = new UserDao();
            User obj = userDao.loginUser(email, password);

            if(obj==null){
                req.setAttribute("error","Invalid email or password");
                req.getRequestDispatcher("pages/login.jsp").forward(req, resp);
                // invalid login
            }
            else{
                HttpSession session = req.getSession();
                session.setAttribute("user",obj);
                resp.sendRedirect("dashboard");
                // login successfull

            }
        }catch (Exception e){
            req.setAttribute("error",e.getMessage());
            req.getRequestDispatcher("pages/login.jsp").forward(req, resp);
            // invalid login
        }

    }

}