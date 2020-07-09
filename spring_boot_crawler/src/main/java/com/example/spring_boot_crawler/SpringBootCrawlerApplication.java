package com.example.spring_boot_crawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootCrawlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCrawlerApplication.class, args);
    }

}
