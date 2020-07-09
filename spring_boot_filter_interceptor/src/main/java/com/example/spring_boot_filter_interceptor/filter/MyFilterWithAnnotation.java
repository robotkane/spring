package com.example.spring_boot_filter_interceptor.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "MyFilterWithAnnotation", urlPatterns = "/api/annotation/*")
public class MyFilterWithAnnotation implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(MyFilterWithAnnotation.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("init MyFilterWithAnnotation:", filterConfig.getFilterName());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("do MyFilterWithAnnotation");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestUri = request.getRequestURI();
        System.out.println("request api:" + requestUri);
        long startTime = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        long endTime = System.currentTimeMillis();
        System.out.println("response time:" + (endTime - startTime));
    }

    @Override
    public void destroy() {
        logger.info("destroy MyFilterWithAnnotation");
    }
}
