package com.learninglog.learninglogproject.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws
            IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        // checking if user is loggedin or not
        HttpSession session = req.getSession(false);
        boolean isLoggedIn = (session != null && session.getAttribute("user") != null);

        // checking if user is request for login / register page or not.
        String uri = req.getRequestURI();
        boolean isAuthPage = (uri.contains("login") || uri.contains("register"));

        if(isLoggedIn && isAuthPage){
            // if user is logged in and try to open login page or register page
//            then redirect to the / index page
            res.sendRedirect("/");
            return;
        }
        if(isLoggedIn || isAuthPage){
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else{
            res.sendRedirect("/login");
        }

    }
}
