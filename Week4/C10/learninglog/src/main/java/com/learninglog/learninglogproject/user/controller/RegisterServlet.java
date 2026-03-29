package com.learninglog.learninglogproject.user.controller;

import com.learninglog.learninglogproject.user.model.dao.UserDao;
import com.learninglog.learninglogproject.user.model.dao.UserDaoInterface;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;

// Map this servlet to URL "/register" with name "registerUser"
@WebServlet(name = "registerUser", value = "/register")
public class RegisterServlet extends HttpServlet {

    // Handles GET request (when user opens registration page)
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException,
            IOException {

        // Forward request to register.jsp page
        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("pages/register.jsp");
        requestDispatcher.forward(req, resp);
    }

    // Handles POST request (when form is submitted)
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException,
            IOException{

        // Get form data from request
        String name = req.getParameter("fullname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // Validate input fields (check empty or null)
        if(name.isEmpty() || email.isEmpty() || password.isEmpty() ||
                name == null || email == null || password == null){

            // Create dispatcher to return to registration page
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/register.jsp");

            // Set error message to display in JSP
            req.setAttribute("error", "Please fill the all fields");

            // Forward back to register page with error message
            requestDispatcher.forward(req, resp);
        }
        if(password.length() < 6){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/register.jsp");

            req.setAttribute("error","Minimum lenght for password is 6");
            requestDispatcher.forward(req, resp);
        }
        UserDaoInterface userDao = new UserDao();

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/register.jsp");
        String  hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt())
;
        try{
            boolean isInserted = userDao.insertUser(name,email,hashedPassword);
            if(isInserted == true){
                req.setAttribute("success","User registered successfully");
                requestDispatcher.forward(req, resp);
            }
            else{
                req.setAttribute("error","Something went wrong");
                requestDispatcher.forward(req,resp);
            }
        }catch (Exception e){
            req.setAttribute("error",e.getMessage());
            requestDispatcher.forward(req,resp);
        }


    }
}