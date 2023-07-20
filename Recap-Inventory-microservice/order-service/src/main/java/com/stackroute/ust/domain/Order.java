package com.stackroute.ust.domain;

import java.time.LocalDate;

public class Order {

    private String orderId;
    private LocalDate orderDate;
    private List<Item> items;
    private int total;

    public Order() {
    }

    public Order(String orderId, LocalDate orderDate, List<Item> items, int total) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.items = items;
        this.total = total;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
