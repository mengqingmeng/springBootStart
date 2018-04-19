package com.example.demo.filter;

import com.example.demo.threadLocal.RequestHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;

import java.io.IOException;
import java.util.logging.LogRecord;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

@Slf4j
public class HttpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("httpFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        RequestHolder.add(Thread.currentThread().getId());
        log.info("do filter,{},{}",Thread.currentThread().getId(),request.getServletPath());
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        log.info("destroy filter");
    }
}
