package com.example.spring_boot_filter_interceptor.config;

import com.example.spring_boot_filter_interceptor.interceptor.LogInterceptor;
import com.example.spring_boot_filter_interceptor.interceptor.OldLoginInterceptor;
import com.example.spring_boot_filter_interceptor.interceptor.adminInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor());
        registry.addInterceptor(new OldLoginInterceptor()).addPathPatterns("/admin/oldLogin");
        registry.addInterceptor(new adminInterceptor()).addPathPatterns("/admin/*").excludePathPatterns("/admin/oldLogin");
    }
}
