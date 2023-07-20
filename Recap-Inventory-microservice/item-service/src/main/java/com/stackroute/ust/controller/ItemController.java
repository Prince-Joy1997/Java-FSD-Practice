package com.stackroute.ust.controller;

import com.stackroute.ust.domain.Item;
import com.stackroute.ust.dto.ItemCodeSearchDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

    private static List<Item> items = List.of(
            new Item("I001", "Item 1", "Item 1 description", 100),
            new Item("I002", "Item 2", "Item 2 description", 150),
            new Item("I003", "Item 3", "Item 3 description", 200)
    );

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Item> getItemById(@PathVariable("code") String code) {
        return ResponseEntity.ok(
                items.stream()
                        .filter(item -> item.getCode().equals(code))
                        .findFirst()
                        .orElseThrow()
        );
    }

    @PostMapping("/search-codes")
    public ResponseEntity<List<Item>> getItemsByIds(@RequestBody ItemCodeSearchDto dto) {
        return ResponseEntity.ok(
                items.stream()
                        .filter(item -> dto.codes().contains(item.getCode()))
                        .toList()
        );
    }
}
