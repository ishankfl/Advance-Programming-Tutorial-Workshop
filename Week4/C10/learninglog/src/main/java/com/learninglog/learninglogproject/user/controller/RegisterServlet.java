package com.learninglog.learninglogproject.user.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "registerUser", value = "/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException,
            IOException {

        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("pages/register.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException,
            IOException{
        String name = req.getParameter("fullname");
        String email = req.getParameter("email");
        String  password = req.getParameter("password");
        if(name.isEmpty() || email.isEmpty() || password.isEmpty() ||
        name==null || email==null || password == null){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/register.jsp");
            req.setAttribute("error","Please fill the all fields");
            requestDispatcher.forward(req,resp);
        }
    }
}
