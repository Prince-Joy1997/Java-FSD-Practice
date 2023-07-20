package com.stackroute.ust.service;

import com.stackroute.ust.dto.Item;
import com.stackroute.ust.dto.ItemCodeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Stream;

public class ItemServiceImpl implements ItemService{

    @Autowired
    private RestTemplate restTemplate;

    private final String itemServiceUrl = "http://item-service/api/v1/items/search-codes";
    @Override
    public List<Item> getItemsByIds(List<String> codes) {
        ItemCodeDto dto =new ItemCodeDto(codes);
        HttpEntity<ItemCodeDto> request = new HttpEntity<>(dto);
        final var response = restTemplate.postForEntity(itemServiceUrl,request, Item[].class);
if (response.getStatusCode().is2xxSuccessful()){
return Stream.of(response.getBody()).toList();
}
        return List.of();
    }
}
