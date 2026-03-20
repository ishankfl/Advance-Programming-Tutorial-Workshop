package com.learninglog.learninglogproject.user.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "registerPage", value = "/register")
public class RegisterServlet extends HttpServlet {
    // for Handle the Get Request
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/register.jsp");
        requestDispatcher.forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String  fullName = req.getParameter("fullname");
        String email = req.getParameter("email");
        String  password = req.getParameter("password");

        if(fullName.isEmpty() || email.isEmpty() || password.isEmpty()){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/register.jsp");

            String message = "Please fill the all fields";
            req.setAttribute("error",message);
            requestDispatcher.forward(req,resp);
        }
    }
}
