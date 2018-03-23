package com.example.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class WebExceptionHandler {
    private static final String ERROR_VIEW="error";

    @ExceptionHandler(value=Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e){
        e.printStackTrace();
        ModelAndView mav = new ModelAndView();
        mav.addObject("error",e);
        mav.addObject("url",request.getRequestURL());
        mav.setViewName(ERROR_VIEW);
        return mav;
    }

}
