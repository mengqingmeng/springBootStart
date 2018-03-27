package com.example.demo.exception;

import com.example.demo.utils.JSONResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

//@RestControllerAdvice
public class AjaxExceptionHandler {

  //@ExceptionHandler(value = Exception.class)
    public JSONResult defaultErrorHandler(HttpServletRequest request, Exception e){
        e.printStackTrace();
        return JSONResult.errorException(e.getMessage());
    }
}
