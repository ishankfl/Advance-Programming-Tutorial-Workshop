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
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest =(HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        HttpSession session = httpRequest.getSession(false);

        boolean isLoggedIn = (session != null && session.getAttribute("user") != null);

        String uri = httpRequest.getRequestURI();

        boolean isLoginPageOrRegisterPage = uri.contains("login") || uri.contains("register");

        if(isLoggedIn && isLoginPageOrRegisterPage){
            httpResponse.sendRedirect("/");
            return;
        }
        if(isLoggedIn || isLoginPageOrRegisterPage){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            httpResponse.sendRedirect("/login");
        }

    }
}
