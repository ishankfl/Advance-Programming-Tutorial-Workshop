package com.learninglog.learninglogproject.user.controller;

import com.learninglog.learninglogproject.user.model.User;
import com.learninglog.learninglogproject.user.model.dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        req.getRequestDispatcher("pages/login.jsp").forward(req,resp);
    }

    @Override
    protected  void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws  ServletException, IOException
    {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        try{

            UserDao dao = new UserDao();
            User userObj = dao.loginUser(email, password);
            if(userObj != null){
                //Login success
                HttpSession session = req.getSession();
                session.setAttribute("user",userObj);

                resp.sendRedirect("/dashboard");

            }
            else{
//                login failed
                req.setAttribute("error","Invalid Username or password");
                req.getRequestDispatcher("pages/login.jsp").forward(req,resp);
            }
        }
        catch (Exception e){
            req.setAttribute("error",e.getMessage());
            req.getRequestDispatcher("pages/login.jsp").forward(req, resp);
        }
    }

}
