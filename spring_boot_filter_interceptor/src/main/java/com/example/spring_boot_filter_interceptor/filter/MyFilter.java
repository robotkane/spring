package com.example.spring_boot_filter_interceptor.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class MyFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("init MyFilter:", filterConfig.getFilterName());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("do MyFilter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestUri = request.getRequestURI();
        System.out.println("MyFilter request api:" + requestUri);
        long startTime = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        long endTime = System.currentTimeMillis();
        System.out.println("MyFilter response time:" + (endTime - startTime));
    }

    @Override
    public void destroy() {
        logger.info("destroy MyFilter");
    }
}
