package com.example.spring_boot_crawler.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "com.example.config")
public class CrawlerProperties {
    private String siteCharset;
    private String urlDetails;
}
