package com.learninglog.learninglogproject.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.rmi.ServerException;

@WebFilter("/*")
public class AuthFilter implements Filter {
    @Override
    public  void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
    throws ServletException, IOException {

        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        HttpServletRequest   httpRequest = (HttpServletRequest) servletRequest;

        String uri = httpRequest.getRequestURI();

        HttpSession session = httpRequest.getSession(false);

        boolean isLoggedIn = (session != null && session.getAttribute("user") != null);
        // islogin= true

        boolean isAuthPage = (uri.contains("login") || uri.contains("register"));
        // false
        if(isLoggedIn && isAuthPage){
            httpResponse.sendRedirect("/");
            return;
        }

        if(isLoggedIn || isAuthPage){
            chain.doFilter(servletRequest,servletResponse);
        }
        else {
            // if user is not logged in then redirect to the login page
            httpResponse.sendRedirect("/login");
        }
    }
}
