package com.example.spring_boot_crawler.task;

import com.example.spring_boot_crawler.pojo.Item;
import com.example.spring_boot_crawler.service.ItemService;
import com.example.spring_boot_crawler.utils.CrawlerProperties;
import com.example.spring_boot_crawler.utils.HttpClientUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ItemTask {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CrawlerProperties crawlerProperties;
    @Autowired
    private HttpClientUtil httpClientUtil;
    @Autowired
    private ItemService itemService;
    @Autowired
    private ObjectMapper objectMapper;

    // 每隔120秒抓取一次
    @Scheduled(fixedDelay = 1000 * 120)
    public void itemTask() throws IOException {
        logger.info("=========执行任务=========");
        String url = crawlerProperties.getUrlDetails().replace("{jfId}", "519674");
        String html = httpClientUtil.doGetHtml(url);
        this.parse(html);
    }

    // 解析html
    private void parse(String html) throws IOException {
        // 解析html获取DOM对象
        Document doc = Jsoup.parse(html);
        // 获取当前页面元素值
        String value = doc.select("#gz_gsz").text();
        String name = doc.select(".funCur-FundName").text();
        String growthRate = doc.select("#gz_gszzl").text();
        logger.info("name:{},value:{},growthRate:{}", name, value, growthRate);
        List<Item> itemList = new ArrayList<>();
        Item item = new Item();
        item.setTitle(name + value + growthRate);
        itemList.add(item);
        itemService.batchSave(itemList);
    }
}
