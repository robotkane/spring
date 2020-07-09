package com.example.spring_boot_filter_interceptor.config;

import com.example.spring_boot_filter_interceptor.filter.MyFilter;
import com.example.spring_boot_filter_interceptor.filter.MyFilter2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class MyFilterConfig {
    @Autowired
    MyFilter myFilter;
    @Autowired
    MyFilter2 myFilter2;

    @Bean
    public FilterRegistrationBean<MyFilter> setUpMyFilter() {
        FilterRegistrationBean<MyFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setOrder(2);
        filterFilterRegistrationBean.setFilter(myFilter);
        filterFilterRegistrationBean.setUrlPatterns(new ArrayList<>(Arrays.asList("/api/*")));
        return filterFilterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<MyFilter2> setUpMyFilter2() {
        FilterRegistrationBean<MyFilter2> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setOrder(1);
        filterFilterRegistrationBean.setFilter(myFilter2);
        filterFilterRegistrationBean.setUrlPatterns(new ArrayList<>(Arrays.asList("/api/*")));
        return filterFilterRegistrationBean;
    }
}
