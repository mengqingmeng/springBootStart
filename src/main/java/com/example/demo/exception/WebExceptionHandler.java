package com.example.demo.exception;

import com.example.demo.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class WebExceptionHandler {
    @Autowired
    private MappingJackson2HttpMessageConverter jsonConverter;

    private static final String ERROR_VIEW="error";

    //网页异常捕获
   // @ExceptionHandler(value=Exception.class)
//    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e){
//        e.printStackTrace();
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("error",e);
//        mav.addObject("url",request.getRequestURL());
//        mav.setViewName(ERROR_VIEW);
//        return mav;
//    }

    //捕获ajax和普通异常
    @ExceptionHandler(value=Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws IOException {
        e.printStackTrace();
        if(isAjax(request)){
            //直接返回IMoocJSONResult是不行的，会再抛出一个
            // Error resolving template template might not exist or might not be accessible 的异常，
            // 需要使用MappingJackson2HttpMessageConverter把IMoocJSONResult手动写入 HttpServletResponse中。
            //return JSONResult.errorException(e.getMessage());
            JSONResult result = JSONResult.errorException(e.getMessage());
            jsonConverter.write(result, MediaType.APPLICATION_JSON, new ServletServerHttpResponse(response));

            return null;
        }else{
            ModelAndView mav = new ModelAndView();
            mav.addObject("error",e);
            mav.addObject("url",request.getRequestURL());
            mav.setViewName(ERROR_VIEW);
            return mav;
        }

    }

    public boolean isAjax(HttpServletRequest request){
        return (request.getHeader("X-Requested-With") !=null &&
                request.getHeader("x-requested-with").toString().equals("XMLHttpRequest"));
    }
}
