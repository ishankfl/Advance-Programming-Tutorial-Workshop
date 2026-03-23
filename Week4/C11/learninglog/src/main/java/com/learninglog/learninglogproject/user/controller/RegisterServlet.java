package com.learninglog.learninglogproject.user.controller;

import com.learninglog.learninglogproject.user.model.User;
import com.learninglog.learninglogproject.user.model.dao.UserDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// This annotation maps the servlet to the URL pattern "/register"
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    // Handles GET requests (when user opens the register page)
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Forward request to register.jsp page
        RequestDispatcher rd = req.getRequestDispatcher("pages/register.jsp");
        rd.forward(req, resp);
    }

    // Handles POST requests (when user submits the registration form)
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Dispatcher to return back to register page if needed
        RequestDispatcher rd = req.getRequestDispatcher("pages/register.jsp");

        // Get form data from request
        String name = req.getParameter("fullname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // Check if any field is empty
        if(name.isEmpty() || email.isEmpty() || password.isEmpty()){

            // Set error message
            String message = "Please fill the all fields";
            req.setAttribute("error", message);

            // Forward back to register page with error message
            rd.forward(req, resp);
        }
        UserDao dao = new UserDao();
        User userObj = new User();
        userObj.setName(name);
        userObj.setEmail(email);
        userObj.setPassword(password);

//        userObj.getName()
        try{
            boolean isInserted = dao.insertUser(userObj);
            if(isInserted==true){
                req.getRequestDispatcher("pages/login.jsp").forward(req,resp);
            }
            else{
                req.setAttribute("error","Something went wrong!");
                req.getRequestDispatcher("pages/register").forward(req,resp);

            }
        }catch (Exception e){
            req.setAttribute("error",e.getMessage());
            req.getRequestDispatcher("pages/register.jsp").forward(req,resp);
        }

    }
}