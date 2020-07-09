package com.example.spring_boot_crawler.dao;

import com.example.spring_boot_crawler.pojo.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDao extends JpaRepository<Item, Long> {
}
