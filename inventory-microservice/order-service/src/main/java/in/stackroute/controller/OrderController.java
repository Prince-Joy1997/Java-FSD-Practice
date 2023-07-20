package in.stackroute.controller;

import in.stackroute.domain.Order;
import in.stackroute.dto.Item;
import in.stackroute.dto.NewOrderDto;
import in.stackroute.service.ItemService;
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
