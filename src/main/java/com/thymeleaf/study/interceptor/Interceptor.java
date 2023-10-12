package com.thymeleaf.study.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception{
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("userInfo") == null){
            response.sendRedirect("/login");
            return false;
        }
        return true;

    }


}
