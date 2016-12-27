package com.base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {
    protected Log log = LogFactory.getLog(BaseController.class);

    /**
     * 封装了异常，不让异常抛出页面
     * @param exception
     * @param response
     * @param request
     * @throws IOException
     * @gbq
     */
    @ExceptionHandler(Exception.class)
    // 在Controller类中添加该注解方法即可(注意：添加到某个controller，只针对该controller起作用)
    public void exceptionHandler(Exception exception,
            HttpServletResponse response, HttpServletRequest request)
            throws IOException {
        log.error(exception.getMessage(), exception);
        response.sendRedirect(request.getContextPath() + "/jsp/404.jsp");
    }
}