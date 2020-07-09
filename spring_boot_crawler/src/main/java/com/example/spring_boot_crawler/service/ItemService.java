package com.example.spring_boot_crawler.service;

import com.example.spring_boot_crawler.pojo.Item;

import java.util.List;

public interface ItemService {
    void batchSave(List<Item> items);

    List<Item> findAll(Item item);
}
