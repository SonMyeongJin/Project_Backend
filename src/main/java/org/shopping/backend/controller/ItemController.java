package org.shopping.backend.controller;

import org.shopping.backend.entity.Item;
import org.shopping.backend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    // Frontend connect Test
    @GetMapping("/api/items")
    public List<Item> getItems() {
        List<Item> items = itemRepository.findAll();
        return items;
    }
}
