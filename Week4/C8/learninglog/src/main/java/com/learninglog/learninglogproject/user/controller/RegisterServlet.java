package com.learninglog.learninglogproject.user.controller;

// Import necessary servlet classes
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// Map this servlet to the URL pattern "/register"
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    // This method handles GET requests (when user visits /register in browser)
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Create a RequestDispatcher to forward request to register.jsp page
        RequestDispatcher rd = req.getRequestDispatcher("pages/register.jsp");

        // Forward the request and response to the JSP page
        // This means the URL stays the same but content is loaded from JSP
        rd.forward(req, resp);
    }
}