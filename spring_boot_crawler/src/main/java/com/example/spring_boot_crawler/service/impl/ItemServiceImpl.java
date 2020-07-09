package com.example.spring_boot_crawler.service.impl;

import com.example.spring_boot_crawler.dao.ItemDao;
import com.example.spring_boot_crawler.pojo.Item;
import com.example.spring_boot_crawler.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;

    @Override
    public List<Item> findAll(Item item) {
        Example<Item> example = Example.of(item);
        return this.itemDao.findAll(example);
    }

    @Override
    public void batchSave(List<Item> items) {
        this.itemDao.saveAll(items);
    }
}
