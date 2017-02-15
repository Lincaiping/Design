package com.base.handlerInterceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandlerInterceptorAdapter implements HandlerInterceptor{

    @Override
    public void afterCompletion(HttpServletRequest req,
            HttpServletResponse res, Object object, Exception exception)
            throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse res,
            Object object, ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
        Integer code =res.getStatus();
        if(code>299){
            res.sendRedirect("/404");
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
            Object object) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

}