package com.elpms.controller;

import com.elpms.model.Item;
import com.elpms.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Author: Duncan MacLeod (101160585)
 *
 * Contains the API mappings and function calls that manipulate the 'item' table in the database
 */
@RestController
@RequestMapping("api/item")
public class ItemController {

    @Autowired
    ItemRepository itemRepo;

    @GetMapping("/getAll")
    public List<Item> getAllItems() {
        return itemRepo.findAll();
    }

    @GetMapping("/findByName")
    public List<Item> findByName(@RequestParam("name") String name) {
        return itemRepo.findByName(name);
    }

    @GetMapping("/findById")
    public Item findById(@RequestParam("id") String id) {

        Optional<Item> account = itemRepo.findById(id);

        return account.orElse(null);
    }

    @RequestMapping(value = "/addItem", method = {RequestMethod.GET, RequestMethod.POST})
    public Item addItem(
            @RequestParam("id") int id, @RequestParam("name") String name,
            @RequestParam("available") boolean available
    ) {

        Item newItem = new Item(id, name, available);

        itemRepo.save(newItem);
        return newItem;
    }
}
