package com.example.spring_boot_filter_interceptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SpringBootFilterInterceptorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFilterInterceptorApplication.class, args);
    }

}
