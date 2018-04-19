package com.example.demo.interceptor;

import com.example.demo.threadLocal.RequestHolder;
import com.example.demo.utils.JSONResult;
import com.example.demo.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
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
 *定义拦截器,和过滤器还是有点不一样滴
 */
@Slf4j
@Component
public class TestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        log.info("============================拦截器启动==============================");
        request.setAttribute("starttime",System.currentTimeMillis());
        return true;//return false; 可以将请求拦截
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        log.info("===========================执行处理完毕=============================");
        long starttime = (long) request.getAttribute("starttime");
        request.removeAttribute("starttime");
        long endtime = System.currentTimeMillis();
        log.info("============请求地址："+request.getRequestURI()+"：处理时间：{}",(endtime-starttime)+"ms");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        RequestHolder.remove();//别忘了移除
        log.info("============================拦截器关闭==============================");
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
