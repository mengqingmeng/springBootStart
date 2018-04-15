package com.example.demo.controller.interceptor;

import com.example.demo.utils.JSONResult;
import com.example.demo.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 *定义拦截器
 */
@Component
public class TestInterceptor implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(TestInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        logger.info("============================拦截器启动==============================");
        request.setAttribute("starttime",System.currentTimeMillis());
        return true;//return false; 可以将请求拦截
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        logger.info("===========================执行处理完毕=============================");
        long starttime = (long) request.getAttribute("starttime");
        request.removeAttribute("starttime");
        long endtime = System.currentTimeMillis();
        logger.info("============请求地址："+request.getRequestURI()+"：处理时间：{}",(endtime-starttime)+"ms");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.info("============================拦截器关闭==============================");
    }

    public void returnErrorResponse(HttpServletRequest request, HttpServletResponse response, JSONResult result) throws IOException {
        OutputStream outputStream = null;
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json");
        try {
            outputStream = response.getOutputStream();
            outputStream.write(JsonUtils.objectToJson(request).getBytes("utf-8"));
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(outputStream!=null){
                outputStream.close();
            }
        }

    }
}
