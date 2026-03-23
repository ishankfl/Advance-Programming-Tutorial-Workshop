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

// Servlet mapped to "/register" URL
@WebServlet(name = "registerPage", value = "/register")
public class RegisterServlet extends HttpServlet {

    // Handles GET requests (when user opens the registration page)
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Forward request to register.jsp page
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/register.jsp");
        requestDispatcher.forward(req, resp);
    }

    // Handles POST requests (when user submits the registration form)
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Get form data from request
        String fullName = req.getParameter("fullname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // Check if any field is empty
        if (fullName.isEmpty() || email.isEmpty() || password.isEmpty()) {

            // Create a dispatcher to return back to registration page
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/register.jsp");

            // Set an error message to be displayed in JSP
            String message = "Please fill the all fields";
            req.setAttribute("error", message);

            // Forward back to register page with the error message
            requestDispatcher.forward(req, resp);
        }
        try{
            UserDao userDao = new UserDao();
            boolean userInserted = userDao.insertUser(fullName, email, password);
            if(userInserted==true){
                req.getRequestDispatcher("pages/login.jsp").forward(req,resp);
            }else{
                req.setAttribute("error","Something went wrong! Please try again");
                req.getRequestDispatcher("pages/register.jsp").forward(req,resp);
            }
        }
        catch (Exception e){
            req.setAttribute("error",e.getMessage());
            req.getRequestDispatcher("pages/register.jsp").forward(req, resp);
        }



        // If fields are not empty, further processing can be done here (e.g., saving user to DB)
    }
}