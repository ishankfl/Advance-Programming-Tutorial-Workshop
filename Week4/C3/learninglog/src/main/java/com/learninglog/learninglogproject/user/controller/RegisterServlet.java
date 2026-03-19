package com.learninglog.learninglogproject.user.controller;


import com.learninglog.learninglogproject.user.model.User;
import com.learninglog.learninglogproject.user.model.dao.UserDao;
import com.learninglog.learninglogproject.user.model.dao.UserDaoInterface;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="registerUser", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher= req.getRequestDispatcher("pages/register.jsp");

        requestDispatcher.forward(req, resp);
    }

    @Override
    protected  void doPost(HttpServletRequest req, HttpServletResponse resp) throws  ServletException, IOException{
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/register.jsp");

        try {


            String name = req.getParameter("fullname");
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                req.setAttribute("error", "Please fill the all fields");
                System.out.println("Please fill this all fields");
                requestDispatcher.forward(req, resp);
            }

            User userObj = new User();

            userObj.setName(name);
            userObj.setEmail(email);
            userObj.setPassword(password);

            UserDaoInterface userDAO = new UserDao();
            boolean result = userDAO.insertUser(userObj);
            if (result) {
                req.setAttribute("success", "Successfully User Added");
            } else {
                req.setAttribute("error", "Something went wrong");
            }
        }catch (Exception e){
            req.setAttribute("error", e.getMessage());
        }
        requestDispatcher.forward(req,resp);

    }
}
