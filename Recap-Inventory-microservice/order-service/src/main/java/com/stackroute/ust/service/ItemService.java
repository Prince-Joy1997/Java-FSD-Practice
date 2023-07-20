package com.stackroute.ust.service;

import com.stackroute.ust.dto.Item;

import java.util.List;

public interface ItemService {
    List<Item> getItemsByIds(List<String> codes);
}
