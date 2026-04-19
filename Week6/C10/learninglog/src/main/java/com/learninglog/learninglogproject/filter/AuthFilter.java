package com.learninglog.learninglogproject.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebFilter("/*")
public class AuthFilter implements Filter {
    public  void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws ServletException, IOException{

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();

        HttpSession session = req.getSession(false);

        boolean isUserLoggedIn = (session != null && session.getAttribute("user") != null);
        boolean isAuthPage = uri.contains("login") || uri.contains("register");

        if(isUserLoggedIn && isAuthPage){
                res.sendRedirect("/");
        }
        if(isUserLoggedIn || isAuthPage){
            chain.doFilter(req,res);
        }
        else {
            res.sendRedirect("/login");
        }

    }
}
