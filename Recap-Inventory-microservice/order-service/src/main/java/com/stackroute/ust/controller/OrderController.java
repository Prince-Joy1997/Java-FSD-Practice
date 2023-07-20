package com.stackroute.ust.controller;

import com.stackroute.ust.domain.Order;
import com.stackroute.ust.dto.Item;
import com.stackroute.ust.dto.NewOrderDto;
import com.stackroute.ust.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private ItemService itemService;

    public OrderController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody NewOrderDto dto) {
        var itemCodes = dto.items();
        var items = itemService.getItemsByIds(itemCodes);
        var total = items.stream().mapToInt(Item::price).sum();
        var order = new Order(dto.orderId(), dto.orderDate(), items, total);
        return ResponseEntity.ok(order);
    }
}
