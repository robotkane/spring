package com.example.spring_boot_crawler.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@EnableConfigurationProperties(CrawlerProperties.class)
public class HttpClientUtil {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CrawlerProperties crawlerProperties;

    private static PoolingHttpClientConnectionManager clientConnectionManager;

    static {
        // 创建连接池
        clientConnectionManager = new PoolingHttpClientConnectionManager();
        // 最大连接数
        clientConnectionManager.setMaxTotal(100);
        // 设置每个主机最大连接数
        clientConnectionManager.setDefaultMaxPerRoute(10);
    }

    private static RequestConfig getRequestConfig() {
        RequestConfig requestConfig = RequestConfig
                .custom()
                .setConnectTimeout(1000)// 创建连接的最长时间，毫秒
                .setConnectionRequestTimeout(500)// 获取链接的最长时间，毫秒
                .setSocketTimeout(1000 * 10)// 数据传输的最长时间，毫秒
                .build();
        return requestConfig;
    }

    // 获取请求地址的html内容
    public String doGetHtml(String url) {
        // 创建HttpClient
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(clientConnectionManager).build();
        // 添加url，构建HttpGet对象
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("User-Agent", "");
        httpGet.setConfig(getRequestConfig());
        logger.info("请求地址：{}", httpGet);

        CloseableHttpResponse response = null;
        try {
            // 发送请求得到响应
            response = httpClient.execute(httpGet);
            // 解析
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                // 响应体不为空
                if (entity != null) {
                    String content = EntityUtils.toString(entity, crawlerProperties.getSiteCharset());
                    logger.info("响应的数据：{}", content);
                    return content;
                }
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }
}
